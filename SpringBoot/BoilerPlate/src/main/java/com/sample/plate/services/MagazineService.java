package com.sample.plate.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sample.plate.models.Magazine;
import com.sample.plate.repositories.MagazineRep;

@Service
public class MagazineService {
	private final MagazineRep magazineRep;
	public MagazineService(MagazineRep magazineRep) {
		this.magazineRep = magazineRep;
	}
	
	public Magazine findMagazineById(Long id) {
		Optional<Magazine> u = magazineRep.findById(id);
		
		if(u.isPresent()) {
	        return u.get();
		} else {
		    return null;
		}
	}
	
	    
}
