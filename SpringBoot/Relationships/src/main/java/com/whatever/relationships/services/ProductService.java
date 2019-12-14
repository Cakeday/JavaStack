package com.whatever.relationships.services;

import java.util.List;
import java.util.Optional;

import com.whatever.relationships.models.Product;
import com.whatever.relationships.repositories.ProductRepository;

import org.springframework.stereotype.Service;

/**
 * ProductService
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;
// The below constructor must match the classname!!!
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // creates and updates a product
    public Product createProduct(Product b) {
        return productRepository.save(b);
    }

    // returns all the products
    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    // retrieves a product
    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }



    // deletes a product
    public void deleteProduct(long id) {
    	productRepository.deleteById(id);
    }
}