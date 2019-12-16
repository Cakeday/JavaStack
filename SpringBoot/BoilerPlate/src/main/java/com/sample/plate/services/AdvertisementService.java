package com.sample.plate.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sample.plate.models.Advertisement;
import com.sample.plate.repositories.AdvertisementRep;

@Service
public class AdvertisementService {
	private final AdvertisementRep advertisementRep;
	public AdvertisementService(AdvertisementRep advertisementRep) {
		this.advertisementRep = advertisementRep;
	}
	public Advertisement findAdvertisementById(Long id) {
		Optional<Advertisement> u = advertisementRep.findById(id);
		
		if(u.isPresent()) {
	        return u.get();
		} else {
		    return null;
		}
	}
}
