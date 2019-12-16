package com.sample.plate.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sample.plate.models.Advertisement;

@Repository
public interface AdvertisementRep extends CrudRepository<Advertisement, Long>{
	List<Advertisement> findAll();
}
