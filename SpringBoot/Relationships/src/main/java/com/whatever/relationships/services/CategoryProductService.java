package com.whatever.relationships.services;

import java.util.List;
import java.util.Optional;

import com.whatever.relationships.models.CategoryProduct;
import com.whatever.relationships.repositories.CategoryProductRepository;

import org.springframework.stereotype.Service;

/**
 * CategoryProductService
 */
@Service
public class CategoryProductService {

    private final CategoryProductRepository categoryProductRepository;
// The below constructor must match the classname!!!
    public CategoryProductService(CategoryProductRepository categoryProductRepository) {
        this.categoryProductRepository = categoryProductRepository;
    }

    // creates and updates a categoryProduct
    public CategoryProduct createCategoryProduct(CategoryProduct b) {
        return categoryProductRepository.save(b);
    }

    // returns all the categoryProducts
    public List<CategoryProduct> allCategoryProducts() {
        return categoryProductRepository.findAll();
    }

    // retrieves a categoryProduct
    public CategoryProduct findCategoryProduct(Long id) {
        Optional<CategoryProduct> optionalCategoryProduct = categoryProductRepository.findById(id);
        if(optionalCategoryProduct.isPresent()) {
            return optionalCategoryProduct.get();
        } else {
            return null;
        }
    }



    // deletes a categoryProduct
    public void deleteCategoryProduct(long id) {
    	categoryProductRepository.deleteById(id);
    }
}