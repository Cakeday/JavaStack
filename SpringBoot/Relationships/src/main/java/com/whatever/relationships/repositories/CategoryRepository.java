package com.whatever.relationships.repositories;

import java.util.List;

import com.whatever.relationships.models.Category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CategoryRepository
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
    List<Category> findAll();
    // this method finds languages with descriptions containing the search string
}