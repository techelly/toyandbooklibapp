package com.toyandbooklibapp.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/toyandbooklibapp")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('PARENT') or hasRole('ADMIN') or hasRole('CHILD')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/parent")
	@PreAuthorize("hasRole('PARENT')")
	public String parentAccess() {
		return "Parent Board.";
	}
	
	@GetMapping("/child")
	@PreAuthorize("hasRole('CHILD')")
	public String childAccess() {
		return "Child Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}