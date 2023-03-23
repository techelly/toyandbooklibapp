package com.toyandbooklibapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toyandbooklibapp.exceptions.LendItemNotFoundException;
import com.toyandbooklibapp.exceptions.ResourceNotFoundException;
import com.toyandbooklibapp.model.LendItem;
import com.toyandbooklibapp.service.ILendItemService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/toyandbooklibapp")
public class LendItemController {
	@Autowired
	private ILendItemService lendItemService;

	@PostMapping("/lendItem/save")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<LendItem> addLendItem(@RequestBody LendItem lendItem) {
		LendItem newLendItem = lendItemService.saveLendItem(lendItem);
		return new ResponseEntity<>(newLendItem, HttpStatus.CREATED);
	}

	@GetMapping("/lendItem/all")
	@PreAuthorize("hasRole('USER') or hasRole('PARENT') or hasRole('ADMIN') or hasRole('CHILD')")
	public ResponseEntity<List<LendItem>> getAllLendItems() throws ResourceNotFoundException {
		List<LendItem> lendItems = lendItemService.viewAllLendItems();
		return new ResponseEntity<>(lendItems, HttpStatus.OK);
	}

	@PutMapping("/lendItem/update")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<LendItem> updateLendItem(@RequestBody LendItem lendItem) throws LendItemNotFoundException {
		LendItem newLendItem = lendItemService.updateLendItem(lendItem);
		ResponseEntity<LendItem> responseEntity = new ResponseEntity<>(newLendItem, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/lendItem/delete")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<LendItem> deleteLendItem(@PathVariable("lendItemId") Integer lendItemId)
			throws LendItemNotFoundException {
		LendItem lendItem = lendItemService.deleteLendItem(lendItemId);
		return new ResponseEntity<>(lendItem, HttpStatus.OK);
	}
}
