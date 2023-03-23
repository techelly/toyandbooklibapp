package com.toyandbooklibapp.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyandbooklibapp.entities.MembershipTypeEntity;
import com.toyandbooklibapp.model.MembershipType;
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
	public List<MembershipType> viewAllMembershipTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MembershipType viewMembershipTypeById(Integer membershiptypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MembershipType deleteMembershipType(int membershipTypeById) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MembershipType updateMembershipType(MembershipType membershipType) {
		// TODO Auto-generated method stub
		return null;
	}

}
