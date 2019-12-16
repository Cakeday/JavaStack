package com.sample.plate.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sample.plate.models.Magazine;

@Repository
public interface MagazineRep extends CrudRepository<Magazine, Long>{
	List<Magazine> findAll();
}
