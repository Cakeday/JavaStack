package com.whatever.relationships.repositories;

import java.util.List;

import com.whatever.relationships.models.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * ProductRepository
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
    List<Product> findAll();
    // this method finds languages with descriptions containing the search string
}