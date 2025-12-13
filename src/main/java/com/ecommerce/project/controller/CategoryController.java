package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoriesService;

    public CategoryController(CategoryService categories) {
        this.categoriesService = categories;
    }

    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories(){
        return categoriesService.getAllCategories();
    }

    @PostMapping("/api/public/categories")
    public String addCategories(@RequestBody Category category){
        categoriesService.addCategories(category);
        return "Successfully added the category";
    }

    @DeleteMapping("/api/public/categories/{id}")
    public String deleteCategory(@PathVariable Long id){
        categoriesService.deleteCategory(id);
        return "Successfully deleted the category";
    }
}
