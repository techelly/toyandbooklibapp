package com.toyandbooklibapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyandbooklibapp.entities.MembershipTypeEntity;
import com.toyandbooklibapp.entities.ParentEntity;
import com.toyandbooklibapp.exceptions.MembershipTypeNotFoundException;
import com.toyandbooklibapp.exceptions.ParentNotFoundException;
import com.toyandbooklibapp.exceptions.ResourceNotFoundException;
import com.toyandbooklibapp.model.MembershipType;
import com.toyandbooklibapp.model.Parent;
import com.toyandbooklibapp.repositories.IMembershipTypeRepository;

@Service
public class MembershipTypeService implements IMembershipTypeService {

	@Autowired
	IMembershipTypeRepository membershipTypeRepository;

	@Override
	public MembershipType saveMembershipType(MembershipType membershipType) {
		// convert membershipType model to membershipType entity

		MembershipTypeEntity membershipTypeEntity = new MembershipTypeEntity();
		BeanUtils.copyProperties(membershipType, membershipTypeEntity);

		MembershipTypeEntity newMembershipTypeEntity = membershipTypeRepository.save(membershipTypeEntity);
		// covert membershipType entity to membershipType model

		MembershipType newMembershipType = new MembershipType();
		BeanUtils.copyProperties(newMembershipTypeEntity, newMembershipType);

		return newMembershipType;
	}

	@Override
	public List<MembershipType> viewAllMembershipTypes() throws ResourceNotFoundException{
		List<MembershipTypeEntity> membershipTypeEntities = (List<MembershipTypeEntity>) membershipTypeRepository.findAll();
		if (membershipTypeEntities.size() > 0) {
			// convert membershipType entity list to membershipType list
			List<MembershipType> membershipTypes = new ArrayList<>();
			membershipTypeEntities.forEach(pentity -> {
				MembershipType membershipType = new MembershipType();
				BeanUtils.copyProperties(pentity, membershipType);
				membershipTypes.add(membershipType);
			});
			return membershipTypes;
		} else {
			throw new ResourceNotFoundException("No membershipTypes found");
		}
	}

	@Override
	public MembershipType viewMembershipTypeById(Integer membershiptypeId) throws MembershipTypeNotFoundException {
		Optional<MembershipTypeEntity> optionalMembershipType = membershipTypeRepository.findById(membershiptypeId);
		if (!optionalMembershipType.isPresent()) {
			throw new MembershipTypeNotFoundException("MembershipType not existing with id:" + membershiptypeId);
		}
		MembershipTypeEntity membershipTypeEntity = optionalMembershipType.get();
		// convert membershipType entity to membershipType model
		MembershipType membershipType = new MembershipType();
		BeanUtils.copyProperties(membershipTypeEntity, membershipType);
		return membershipType;
	}

	@Override
	public MembershipType deleteMembershipType(int membershipTypeById) throws MembershipTypeNotFoundException{
		Optional<MembershipTypeEntity> optionalMembershipType = membershipTypeRepository.findById(membershipTypeById);
		if (!optionalMembershipType.isPresent()) {
			throw new MembershipTypeNotFoundException("MembershipType not existing with id:" + membershipTypeById);
		}
		MembershipTypeEntity membershipTypeEntity = optionalMembershipType.get();
		membershipTypeRepository.delete(membershipTypeEntity);
		// convert membershipType entity to membershipType model
		MembershipType membershipType = new MembershipType();
		BeanUtils.copyProperties(membershipTypeEntity, membershipType);
		return membershipType;
	}

	@Override
	public MembershipType updateMembershipType(MembershipType membershipType) throws MembershipTypeNotFoundException{
		Optional<MembershipTypeEntity> optionalMembershipType = membershipTypeRepository.findById(membershipType.getMembershipTypeId());
		if (!optionalMembershipType.isPresent()) {
			throw new MembershipTypeNotFoundException("MembershipType not existing with id:" + membershipType.getMembershipTypeId());
		}
		MembershipTypeEntity membershipTypeEntity = optionalMembershipType.get();
		// convert MembershipType entity to MembershipType model
		MembershipType newMembershipType = new MembershipType();
		BeanUtils.copyProperties(membershipTypeEntity, newMembershipType);

		MembershipTypeEntity newMembershipTypeEntity = membershipTypeRepository.save(membershipTypeEntity);
		// convert MembershipType entity to MembershipType model
		MembershipType nMembershipType = new MembershipType();
		BeanUtils.copyProperties(newMembershipTypeEntity, nMembershipType);
		return nMembershipType;
	}

}
