package com.whatever.relationships.repositories;

import java.util.List;

import com.whatever.relationships.models.CategoryProduct;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CategoryProduct
 */
@Repository
public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long>{
    List<CategoryProduct> findAll();
    // this method finds languages with descriptions containing the search string
}