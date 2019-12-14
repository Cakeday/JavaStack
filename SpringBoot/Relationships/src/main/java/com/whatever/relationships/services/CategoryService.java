package com.whatever.relationships.services;

import java.util.List;
import java.util.Optional;

import com.whatever.relationships.models.Category;
import com.whatever.relationships.repositories.CategoryRepository;

import org.springframework.stereotype.Service;

/**
 * CategoryService
 */
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
// The below constructor must match the classname!!!
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // creates and updates a category
    public Category createCategory(Category b) {
        return categoryRepository.save(b);
    }

    // returns all the categories
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    // retrieves a category
    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }



    // deletes a category
    public void deleteCategory(long id) {
    	categoryRepository.deleteById(id);
    }
}