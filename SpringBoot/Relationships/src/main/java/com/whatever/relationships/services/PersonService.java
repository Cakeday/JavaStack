package com.whatever.relationships.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.whatever.relationships.models.Person;
import com.whatever.relationships.repositories.LicenseRepository;
import com.whatever.relationships.repositories.PersonRepository;

import org.springframework.stereotype.Service;

/**
 * PersonService
 */
@Service
public class PersonService {

    private final PersonRepository personRepository;
// The below constructor must match the classname!!!
    public PersonService(PersonRepository personRepository, LicenseRepository licenseRepository) {
        this.personRepository = personRepository;
    }

    // creates and updates a person
    public Person createPerson(Person b) {
        return personRepository.save(b);
    }

    // returns all the persons
    public List<Person> allPersons() {
        return personRepository.findAll();
    }

    // retrieves a person
    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }

    // deletes a person
    public void deletePerson(long id) {
    	personRepository.deleteById(id);
    }










    // Gets people without id's
    public ArrayList<Person> getPeopleWithoutId(){
        List<Person> thePeople = personRepository.findAll();
        ArrayList<Person> newList = new ArrayList<Person>();
        for(Person person : thePeople){
            if(person.getLicense()==null){
                newList.add(person);
            }
        }
        return newList;
    }
}