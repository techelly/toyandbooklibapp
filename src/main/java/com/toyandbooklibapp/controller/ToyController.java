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

import com.toyandbooklibapp.exceptions.ResourceNotFoundException;
import com.toyandbooklibapp.exceptions.ToyNotFoundException;
import com.toyandbooklibapp.model.Toy;
import com.toyandbooklibapp.service.IToyService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/toyandbooklibapp")
public class ToyController {
	@Autowired
	private IToyService toyService;

	@PostMapping("/toy/save")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Toy> addToy(@RequestBody Toy toy) {
		Toy newToy = toyService.saveToy(toy);
		ResponseEntity<Toy> responseEntity = new ResponseEntity<>(newToy, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/toy/{toyId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Toy> getToy(@PathVariable("toyId") int toyId) throws ToyNotFoundException{
		Toy toy = toyService.viewtoyById(toyId);
		ResponseEntity<Toy> responseEntity = new ResponseEntity<>(toy, HttpStatus.OK);
		return responseEntity;

	}

	@GetMapping("/toy/all")
	@PreAuthorize("hasRole('USER') or hasRole('PARENT') or hasRole('ADMIN') or hasRole('CHILD')")
	public ResponseEntity<List<Toy>> getAllToys() throws ResourceNotFoundException{
		List<Toy> toys = toyService.viewAllToys();
		ResponseEntity<List<Toy>> responseEntity = new ResponseEntity<>(toys, HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping("/toy/update")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Toy> updateToy(@RequestBody Toy toy) throws ToyNotFoundException{
		Toy newToy = toyService.updateToy(toy);
		ResponseEntity<Toy> responseEntity = new ResponseEntity<>(newToy, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/toy/delete/{toyId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Toy> deleteToy(@PathVariable("toyId") int toyId) throws ToyNotFoundException{
		Toy toy = toyService.deleteToy(toyId);
		ResponseEntity<Toy> responseEntity = new ResponseEntity<>(toy, HttpStatus.OK);
		return responseEntity;
	}
}
