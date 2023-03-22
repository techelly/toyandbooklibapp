package com.toyandbooklibapp.service;

import java.util.List;

import com.toyandbooklibapp.exceptions.ResourceNotFoundException;
import com.toyandbooklibapp.exceptions.ToyNotFoundException;
import com.toyandbooklibapp.model.Toy;

public interface IToyService {

	public Toy saveToy(Toy toy);

	public Toy viewtoyById(int toyId) throws ToyNotFoundException;

	public List<Toy> viewAllToys() throws ResourceNotFoundException;

	public Toy updateToy(Toy toy) throws ToyNotFoundException;

	public Toy deleteToy(int toyId) throws ToyNotFoundException;

}
