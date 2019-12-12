package com.whatever.relationships.repositories;

import java.util.List;

import com.whatever.relationships.models.License;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * LicenseRepository
 */
@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
    List<License> findAll();
    // this method finds languages with descriptions containing the search string
}