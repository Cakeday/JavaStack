package com.whatever.relationships.services;

import java.util.List;
import java.util.Optional;

import com.whatever.relationships.models.Dojo;
import com.whatever.relationships.repositories.DojoRepository;

import org.springframework.stereotype.Service;

/**
 * DojoService
 */
@Service
public class DojoService {

    private final DojoRepository dojoRepository;
// The below constructor must match the classname!!!
    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    // creates and updates a dojo
    public Dojo createDojo(Dojo b) {
        return dojoRepository.save(b);
    }

    // returns all the dojos
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }

    // retrieves a dojo
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }



    // deletes a dojo
    public void deleteDojo(long id) {
    	dojoRepository.deleteById(id);
    }
}