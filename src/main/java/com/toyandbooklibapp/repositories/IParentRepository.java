package com.toyandbooklibapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.toyandbooklibapp.entities.ParentEntity;

@Repository
public interface IParentRepository extends CrudRepository<ParentEntity, Integer>{

}
