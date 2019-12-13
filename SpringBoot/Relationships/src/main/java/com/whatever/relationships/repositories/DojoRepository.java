package com.whatever.relationships.repositories;

import java.util.List;

import com.whatever.relationships.models.Dojo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * DojoRepository
 */
@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{
    List<Dojo> findAll();
    // this method finds languages with descriptions containing the search string
}