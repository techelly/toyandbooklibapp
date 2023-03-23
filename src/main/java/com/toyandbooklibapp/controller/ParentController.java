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

import com.toyandbooklibapp.exceptions.ParentNotFoundException;
import com.toyandbooklibapp.exceptions.ResourceNotFoundException;
import com.toyandbooklibapp.model.MembershipType;
import com.toyandbooklibapp.model.Parent;
import com.toyandbooklibapp.service.IParentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/toyandbooklibapp")
public class ParentController {
	@Autowired
	private IParentService parentService;

	@PostMapping("/payment/save")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Parent> addParent(@RequestBody Parent parent) {
		Parent newParent = parentService.saveParent(parent);
		return new ResponseEntity<>(newParent, HttpStatus.CREATED);
	}

	@GetMapping("/parent/{parentId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Parent> getParent(@PathVariable("parentId") int parentId) throws ParentNotFoundException {
		Parent parent = parentService.viewParent(parentId);
		return new ResponseEntity<>(parent, HttpStatus.OK);
	}

	@GetMapping("/parent/all")
	@PreAuthorize("hasRole('USER') or hasRole('PARENT') or hasRole('ADMIN') or hasRole('CHILD')")
	public ResponseEntity<List<Parent>> getAllParents()  throws ResourceNotFoundException{
		List<Parent> parents = parentService.viewAllParents();
		return new ResponseEntity<>(parents, HttpStatus.OK);
	}
	
	@PutMapping("/parent/update")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Parent> updateParent(@RequestBody Parent parent) throws ParentNotFoundException{
		Parent newParent = parentService.updateParent(parent);
		ResponseEntity<Parent> responseEntity = new ResponseEntity<>(newParent, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/parent/delete")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Parent> deleteParent(@PathVariable("parentId")Integer parentId) throws ParentNotFoundException{
		Parent parent = parentService.deleteParent(parentId);
		return new ResponseEntity<>(parent, HttpStatus.OK);
	}
		
	@GetMapping("/parent/bymembershiptype")
	@PreAuthorize("hasRole('USER') or hasRole('PARENT') or hasRole('ADMIN') or hasRole('CHILD')")
	public ResponseEntity<Parent> getParentByMembershipType(@RequestBody MembershipType membershipType) throws ParentNotFoundException{
		Parent parent = parentService.getParentByMembershipType(membershipType);
		return new ResponseEntity<>(parent, HttpStatus.OK);
	}
}
