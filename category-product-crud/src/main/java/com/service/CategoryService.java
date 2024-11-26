package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.entity.Category;
import com.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Get all categories
//    public List<Category> getAllCategories() {
//        return categoryRepository.findAll();
//    }
    
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    // Get category by id
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    // Create a new category
//    public Category createCategory(Category category) {
//        return categoryRepository.save(category);
//    }
    
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Update category
    public Category updateCategory(Long id, Category categoryDetails) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            category.get().setName(categoryDetails.getName());
            return categoryRepository.save(category.get());
        }
        return null;
    }

    // Delete category by id
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}

