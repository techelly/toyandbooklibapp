package com.toyandbooklibapp.service;

import java.util.List;

import com.toyandbooklibapp.model.MembershipType;

public interface IMembershipTypeService {
	public MembershipType saveMembershipType(MembershipType membershipType);
	public List<MembershipType> viewAllMembershipTypes();
	public MembershipType viewMembershipTypeById(Integer membershiptypeId);
	public MembershipType deleteMembershipType(int membershipTypeById);
	public MembershipType updateMembershipType(MembershipType membershipType);
		

}
