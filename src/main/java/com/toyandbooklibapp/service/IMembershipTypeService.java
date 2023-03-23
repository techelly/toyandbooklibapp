package com.toyandbooklibapp.service;

import java.util.List;

import com.toyandbooklibapp.exceptions.MembershipTypeNotFoundException;
import com.toyandbooklibapp.exceptions.ResourceNotFoundException;
import com.toyandbooklibapp.model.MembershipType;

public interface IMembershipTypeService {
	public MembershipType saveMembershipType(MembershipType membershipType);

	public List<MembershipType> viewAllMembershipTypes() throws ResourceNotFoundException;

	public MembershipType viewMembershipTypeById(Integer membershiptypeId) throws MembershipTypeNotFoundException;

	public MembershipType deleteMembershipType(int membershipTypeById) throws MembershipTypeNotFoundException;

	public MembershipType updateMembershipType(MembershipType membershipType) throws MembershipTypeNotFoundException;

}
