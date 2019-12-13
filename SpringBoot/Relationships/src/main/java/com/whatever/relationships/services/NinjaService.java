package com.whatever.relationships.services;

import java.util.List;
import java.util.Optional;

import com.whatever.relationships.models.Ninja;
import com.whatever.relationships.repositories.NinjaRepository;

import org.springframework.stereotype.Service;

/**
 * NinjaService
 */
@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
// The below constructor must match the classname!!!
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // creates and updates a ninja
    public Ninja createNinja(Ninja b) {
        return ninjaRepository.save(b);
    }

    // returns all the ninjas
    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }

    // retrieves a ninja
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }



    // deletes a ninja
    public void deleteNinja(long id) {
    	ninjaRepository.deleteById(id);
    }
}