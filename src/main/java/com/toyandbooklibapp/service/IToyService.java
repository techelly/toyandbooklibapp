package com.toyandbooklibapp.service;

import java.util.List;

import com.toyandbooklibapp.model.Toy;

public interface IToyService {

	public Toy saveToy(Toy toy);

	public Toy viewtoyById(int toyId);

	public List<Toy> viewAllToys();

	public Toy updateToy(Toy toy);

	public Toy deleteToy(int toyId);

}
