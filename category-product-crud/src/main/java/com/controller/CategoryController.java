package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.entity.Category;
import com.service.CategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Get all categories with pagination
    @GetMapping
    public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page) {
        return categoryService.getAllCategories(PageRequest.of(page, 10)); // 10 items per page
    }

 // Create a new category
 //   @PostMapping
//    public Category createCategory(@RequestBody Category category) {
//        return categoryService.createCategory(category);
//    }
    
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        // Call the service to save the category
        Category savedCategory = categoryService.saveCategory(category);
        return ResponseEntity.ok(savedCategory);
    }

    // Get category by id
    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    // Update category by id
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        return categoryService.updateCategory(id, categoryDetails);
    }

    // Delete category by id
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
