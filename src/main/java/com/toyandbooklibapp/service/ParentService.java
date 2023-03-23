package com.toyandbooklibapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyandbooklibapp.entities.ParentEntity;
import com.toyandbooklibapp.exceptions.ParentNotFoundException;
import com.toyandbooklibapp.exceptions.ResourceNotFoundException;
import com.toyandbooklibapp.model.MembershipType;
import com.toyandbooklibapp.model.Parent;
import com.toyandbooklibapp.repositories.IParentRepository;

@Service
public class ParentService implements IParentService {

	@Autowired
	private IParentRepository parentRepository;

	@Override
	public Parent saveParent(Parent parent) {
		// convert parent model to parent entity

		ParentEntity parentEntity = new ParentEntity();
		BeanUtils.copyProperties(parent, parentEntity);

		ParentEntity newParentEntity = parentRepository.save(parentEntity);
		// covert parent entity to parent model

		Parent newParent = new Parent();
		BeanUtils.copyProperties(newParentEntity, newParent);

		return newParent;
	}

	@Override
	public List<Parent> viewAllParents() {
		List<ParentEntity> parentEntities = (List<ParentEntity>) parentRepository.findAll();
		if (parentEntities.size() > 0) {
			// convert parent entity list to parent list
			List<Parent> parents = new ArrayList<>();
			parentEntities.forEach(pentity -> {
				Parent parent = new Parent();
				BeanUtils.copyProperties(pentity, parent);
				parents.add(parent);
			});
			return parents;
		} else {
			throw new ResourceNotFoundException("No parents found");
		}
	}

	@Override
	public Parent updateParent(Parent parent) throws ParentNotFoundException {
		Optional<ParentEntity> optionalParent = parentRepository.findById(parent.getParentId());
		if (!optionalParent.isPresent()) {
			throw new ParentNotFoundException("Toy not existing with id:" + parent.getParentId());
		}
		ParentEntity parentEntity = optionalParent.get();
		// convert parent entity to parent model
		Parent newParent = new Parent();
		BeanUtils.copyProperties(parentEntity, newParent);

		ParentEntity newParentEntity = parentRepository.save(parentEntity);
		// convert toy entity to toy model
		Parent nParent = new Parent();
		BeanUtils.copyProperties(newParentEntity, nParent);
		return nParent;
	}

	@Override
	public Parent deleteParent(Integer parentId) throws ParentNotFoundException{
		
		Optional<ParentEntity> optionalParent = parentRepository.findById(parentId);
		if (!optionalParent.isPresent()) {
			throw new ParentNotFoundException("Parent not existing with id:" + parentId);
		}
		ParentEntity parentEntity = optionalParent.get();
		parentRepository.delete(parentEntity);
		// convert parent entity to parent model
		Parent parent = new Parent();
		BeanUtils.copyProperties(parentEntity, parent);
		return parent;
	}

	@Override
	public Parent viewParent(Integer parentId) throws ParentNotFoundException {
		Optional<ParentEntity> optionalParent = parentRepository.findById(parentId);
		if (!optionalParent.isPresent()) {
			throw new ParentNotFoundException("Parent not existing with id:" + parentId);
		}
		ParentEntity parentEntity = optionalParent.get();
		// convert parent entity to parent model
		Parent parent = new Parent();
		BeanUtils.copyProperties(parentEntity, parent);
		return parent;
	}
	
	/**
	 * Test properly
	 * @throws ParentNotFoundException 
	 */
	@Override
	public Parent getParentByMembershipType(MembershipType membershiptType) throws ParentNotFoundException {
		Integer parentId = membershiptType.getPayments().get(0).getParent().getParentId();
		Optional<ParentEntity> optionalParent = parentRepository.findById(parentId);
		if (!optionalParent.isPresent()) {
			throw new ParentNotFoundException("Parent not existing with id:" + parentId);
		}
		ParentEntity parentEntity = optionalParent.get();
		// convert parent entity to parent model
		Parent parent = new Parent();
		BeanUtils.copyProperties(parentEntity, parent);
		return parent;
	}

}
