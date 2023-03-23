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

import com.toyandbooklibapp.exceptions.MembershipTypeNotFoundException;
import com.toyandbooklibapp.exceptions.ResourceNotFoundException;
import com.toyandbooklibapp.model.MembershipType;
import com.toyandbooklibapp.service.IMembershipTypeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/toyandbooklibapp")
public class MembershipTypeController {
	
	@Autowired
	private IMembershipTypeService membershipTypeService;

	@PostMapping("/membershipType/save")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<MembershipType> addMembershipType(@RequestBody MembershipType membershipType) {
		MembershipType newMembershipType = membershipTypeService.saveMembershipType(membershipType);
		return new ResponseEntity<>(newMembershipType, HttpStatus.CREATED);
	}

	@GetMapping("/membershipType/{membershipTypeId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<MembershipType> getMembershipType(@PathVariable("membershipTypeId") int membershipTypeId) throws MembershipTypeNotFoundException {
		MembershipType membershipType = membershipTypeService.viewMembershipTypeById(membershipTypeId);
		return new ResponseEntity<>(membershipType, HttpStatus.OK);
	}

	@GetMapping("/membershipType/all")
	@PreAuthorize("hasRole('USER') or hasRole('PARENT') or hasRole('ADMIN') or hasRole('CHILD')")
	public ResponseEntity<List<MembershipType>> getAllMembershipTypes()  throws ResourceNotFoundException{
		List<MembershipType> membershipTypes = membershipTypeService.viewAllMembershipTypes();
		return new ResponseEntity<>(membershipTypes, HttpStatus.OK);
	}
	
	@PutMapping("/pament/update")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<MembershipType> updateMembershipType(@RequestBody MembershipType membershipType) throws MembershipTypeNotFoundException{
		MembershipType newMembershipType = membershipTypeService.updateMembershipType(membershipType);
		ResponseEntity<MembershipType> responseEntity = new ResponseEntity<>(newMembershipType, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/membershipType/delete")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<MembershipType> deleteMembershipType(@PathVariable("membershipTypeId")Integer membershipTypeId) throws MembershipTypeNotFoundException{
		MembershipType membershipType = membershipTypeService.deleteMembershipType(membershipTypeId);
		return new ResponseEntity<>(membershipType, HttpStatus.OK);
	}
	
	
}
