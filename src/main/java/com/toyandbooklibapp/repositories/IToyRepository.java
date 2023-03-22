package com.toyandbooklibapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.toyandbooklibapp.entities.ToyEntity;

@Repository
public interface IToyRepository extends CrudRepository<ToyEntity, Integer>{

}
