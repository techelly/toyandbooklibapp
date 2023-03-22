package com.toyandbooklibapp.service;

import java.util.List;

import com.toyandbooklibapp.model.MembershipType;
import com.toyandbooklibapp.model.Parent;

public interface IParentService {
	public Parent saveParent(Parent parent);
	public List<Parent> viewAllParents();
	public Parent updateParent(Parent parent);
	public Parent deleteParent(Integer parentId);
	public Parent viewParent(Integer parentId);
	public Parent getParentByMembershipType(MembershipType membershiptType);

}
