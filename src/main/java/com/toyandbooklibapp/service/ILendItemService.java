package com.toyandbooklibapp.service;

import java.util.List;

import com.toyandbooklibapp.exceptions.LendItemNotFoundException;
import com.toyandbooklibapp.exceptions.ResourceNotFoundException;
import com.toyandbooklibapp.model.LendItem;

public interface ILendItemService {

	public LendItem saveLendItem(LendItem lendItem);

	public LendItem updateLendItem(LendItem lendItem) throws LendItemNotFoundException;

	public LendItem deleteLendItem(Integer lendId) throws LendItemNotFoundException;

	public List<LendItem> viewAllLendItems() throws ResourceNotFoundException;

}
