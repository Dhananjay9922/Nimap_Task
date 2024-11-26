package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all products
//    public List<Product> getAllProducts() {
//        return productRepository.findAll();
//    }
    
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    // Get product by id
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Create a new product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Update product
    public Product updateProduct(Long id, Product productDetails) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            product.get().setName(productDetails.getName());
            product.get().setPrice(productDetails.getPrice());
            product.get().setCategory(productDetails.getCategory());
            return productRepository.save(product.get());
        }
        return null;
    }

    // Delete product by id
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

