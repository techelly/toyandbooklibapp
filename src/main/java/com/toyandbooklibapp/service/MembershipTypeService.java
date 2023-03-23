package com.toyandbooklibapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyandbooklibapp.model.MembershipType;
import com.toyandbooklibapp.repositories.IMembershipTypeRepository;

@Service
public class MembershipTypeService implements IMembershipTypeService {

	@Autowired
	IMembershipTypeRepository membershipTypeRepository;
	@Override
	public MembershipType saveMembershipType(MembershipType membershipType) {
		// TODO Auto-generated method stub
		return null;
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
