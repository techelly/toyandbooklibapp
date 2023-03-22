package com.toyandbooklibapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.toyandbooklibapp.entities.LendItemEntity;

@Repository
public interface ILendItemRepository extends CrudRepository<LendItemEntity, Integer>{

}
