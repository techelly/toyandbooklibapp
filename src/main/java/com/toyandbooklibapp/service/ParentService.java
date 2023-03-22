package com.toyandbooklibapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyandbooklibapp.model.MembershipType;
import com.toyandbooklibapp.model.Parent;
import com.toyandbooklibapp.repositories.IParentRepository;

@Service
public class ParentService implements IParentService {
	
	@Autowired
	private IParentRepository parentRepository;
	
	
	@Override
	public Parent saveParent(Parent parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parent> viewAllParents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parent updateParent(Parent parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parent deleteParent(Integer parentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parent viewParent(Integer parentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parent getParentByMembershipType(MembershipType membershiptType) {
		// TODO Auto-generated method stub
		return null;
	}

}
