package com.toyandbooklibapp.service;

import java.util.List;

import com.toyandbooklibapp.exceptions.ParentNotFoundException;
import com.toyandbooklibapp.exceptions.ResourceNotFoundException;
import com.toyandbooklibapp.model.MembershipType;
import com.toyandbooklibapp.model.Parent;

public interface IParentService {
	public Parent saveParent(Parent parent);
	public List<Parent> viewAllParents() throws ResourceNotFoundException;
	public Parent updateParent(Parent parent) throws ParentNotFoundException;
	public Parent deleteParent(Integer parentId) throws ParentNotFoundException;
	public Parent viewParent(Integer parentId) throws ParentNotFoundException;
	public Parent getParentByMembershipType(MembershipType membershiptType) throws ParentNotFoundException;

}
