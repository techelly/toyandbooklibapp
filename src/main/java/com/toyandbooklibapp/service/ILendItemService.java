package com.toyandbooklibapp.service;

import java.util.List;

import com.toyandbooklibapp.model.LendItem;

public interface ILendItemService {
	
	public LendItem saveLendItem(LendItem lendItem);
	public LendItem updateLendItem(LendItem lendItem);
	public LendItem deleteLendItem(Integer lendId);
	public List<LendItem> viewAllLendItems();

}
