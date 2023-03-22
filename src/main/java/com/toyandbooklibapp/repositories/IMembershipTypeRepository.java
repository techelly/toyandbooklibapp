package com.toyandbooklibapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.toyandbooklibapp.entities.MembershipTypeEntity;

@Repository
public interface IMembershipTypeRepository extends CrudRepository<MembershipTypeEntity, Integer> {

}
