package com.toyandbooklibapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyandbooklibapp.entities.ToyEntity;
import com.toyandbooklibapp.exceptions.ResourceNotFoundException;
import com.toyandbooklibapp.exceptions.ToyNotFoundException;
import com.toyandbooklibapp.model.Toy;
import com.toyandbooklibapp.repositories.IToyRepository;


@Service
public class ToyService implements IToyService {
	
	@Autowired
	private IToyRepository toyRepository;
	@Override
	public Toy saveToy(Toy toy) {
		// convert toy model to toy entity

		ToyEntity toyEntity = new ToyEntity();
		BeanUtils.copyProperties(toy, toyEntity);

		ToyEntity newToyEntity = toyRepository.save(toyEntity);
		// covert toy entity to toy model

		Toy newToy = new Toy();
		BeanUtils.copyProperties(newToyEntity, newToy);

		return newToy;

	}

	@Override
	public Toy viewtoyById(int toyId)  throws ToyNotFoundException{
		Optional<ToyEntity> optionalToy = toyRepository.findById(toyId);
		if (!optionalToy.isPresent()) {
			throw new ToyNotFoundException("Toy not existing with id:" + toyId);
		}
		ToyEntity toyEntity = optionalToy.get();
		// convert toy entity to toy model
		Toy toy = new Toy();
		BeanUtils.copyProperties(toyEntity, toy);
		return toy;
	}

	@Override
	public List<Toy> viewAllToys() throws ResourceNotFoundException{
		List<ToyEntity> toyEntities = (List<ToyEntity>) toyRepository.findAll();
		if (!toyEntities.isEmpty()) {
			// convert toy entity list to toy list
			List<Toy> toys = new ArrayList<>();
			toyEntities.forEach(pentity -> {
				Toy toy = new Toy();
				BeanUtils.copyProperties(pentity, toy);
				toys.add(toy);
			});
			return toys;
		} else {
			throw new ResourceNotFoundException("No toys found");
		}
	}

	@Override
	public Toy updateToy(Toy toy) throws ToyNotFoundException {
		Optional<ToyEntity> optionalToy = toyRepository.findById(toy.getToyId());
		if (!optionalToy.isPresent()) {
			throw new ToyNotFoundException("Toy not existing with id:" + toy.getToyId());
		}
		ToyEntity toyEntity = optionalToy.get();
		// convert toy entity to toy model
		Toy newToy = new Toy();
		BeanUtils.copyProperties(toyEntity, newToy);

		ToyEntity newToyEntity = toyRepository.save(toyEntity);
		// convert toy entity to toy model
		Toy nToy = new Toy();
		BeanUtils.copyProperties(newToyEntity, nToy);
		return nToy;
	}

	@Override
	public Toy deleteToy(int toyId) throws ToyNotFoundException{
		Optional<ToyEntity> optionalToy = toyRepository.findById(toyId);
		if (!optionalToy.isPresent()) {
			throw new ToyNotFoundException("Toy not existing with id:" + toyId);
		}
		ToyEntity toyEntity = optionalToy.get();
		toyRepository.delete(toyEntity);
		// convert toy entity to toy model
		Toy toy = new Toy();
		BeanUtils.copyProperties(toyEntity, toy);
		return toy;
	}
	

}
