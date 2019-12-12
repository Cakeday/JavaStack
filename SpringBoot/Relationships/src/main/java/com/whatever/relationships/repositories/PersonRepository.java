package com.whatever.relationships.repositories;

import java.util.List;

import com.whatever.relationships.models.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * PersonRepository
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
    List<Person> findAll();
    // this method finds languages with descriptions containing the search string
    
}
