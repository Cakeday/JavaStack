package com.whatever.relationships.repositories;

import java.util.List;

import com.whatever.relationships.models.Ninja;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * NinjaRepository
 */
@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
    List<Ninja> findAll();
    // this method finds languages with descriptions containing the search string
}