package com.toyandbooklibapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.toyandbooklibapp.entities.LendItemEntity;
import com.toyandbooklibapp.entities.PaymentEntity;
import com.toyandbooklibapp.exceptions.LendItemNotFoundException;
import com.toyandbooklibapp.exceptions.PaymentNotFoundException;
import com.toyandbooklibapp.exceptions.ResourceNotFoundException;
import com.toyandbooklibapp.model.LendItem;
import com.toyandbooklibapp.model.Payment;
import com.toyandbooklibapp.repositories.ILendItemRepository;

public class LendItemService implements ILendItemService {

	@Autowired
	private ILendItemRepository lendItemRepository;

	@Override
	public LendItem saveLendItem(LendItem lendItem) {
		// convert lendItem model to lendItem entity

		LendItemEntity lendItemEntity = new LendItemEntity();
		BeanUtils.copyProperties(lendItem, lendItemEntity);

		LendItemEntity newLendItemEntity = lendItemRepository.save(lendItemEntity);
		// covert LendItem entity to LendItem model

		LendItem newLendItem = new LendItem();
		BeanUtils.copyProperties(newLendItemEntity, newLendItem);

		return newLendItem;
	}

	@Override
	public LendItem updateLendItem(LendItem lendItem) throws LendItemNotFoundException {
		Optional<LendItemEntity> optionalLendItem = lendItemRepository.findById(lendItem.getLendId());
		if (!optionalLendItem.isPresent()) {
			throw new LendItemNotFoundException("LendItem not existing with id:" + lendItem.getLendId());
		}
		LendItemEntity lendItemEntity = optionalLendItem.get();
		// convert LendItem entity to LendItem model
		LendItem newLendItem = new LendItem();
		BeanUtils.copyProperties(lendItemEntity, newLendItem);

		LendItemEntity newLendItemEntity = lendItemRepository.save(lendItemEntity);
		// convert LendItem entity to LendItem model
		LendItem nLendItem = new LendItem();
		BeanUtils.copyProperties(newLendItemEntity, nLendItem);
		return nLendItem;
	}

	@Override
	public LendItem deleteLendItem(Integer lendId) throws LendItemNotFoundException {
		Optional<LendItemEntity> optionalLendItem = lendItemRepository.findById(lendId);
		if (!optionalLendItem.isPresent()) {
			throw new LendItemNotFoundException("LendItem not existing with id:" + lendId);
		}
		LendItemEntity lendItemEntity = optionalLendItem.get();
		lendItemRepository.delete(lendItemEntity);
		// convert lendItem entity to lendItem model
		LendItem lendItem = new LendItem();
		BeanUtils.copyProperties(lendItemEntity, lendItem);
		return lendItem;
	}

	@Override
	public List<LendItem> viewAllLendItems() throws ResourceNotFoundException{
		List<LendItemEntity> lendItemEntities = (List<LendItemEntity>) lendItemRepository.findAll();
		if (lendItemEntities.size() > 0) {
			// convert LendItem entity list to LendItem list
			List<LendItem> lendItems = new ArrayList<>();
			lendItemEntities.forEach(pentity -> {
				LendItem lendItem = new LendItem();
				BeanUtils.copyProperties(pentity, lendItem);
				lendItems.add(lendItem);
			});
			return lendItems;
		} else {
			throw new ResourceNotFoundException("No lendItems found");
		}
	}

}
