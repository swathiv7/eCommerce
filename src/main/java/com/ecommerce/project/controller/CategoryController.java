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

    @PutMapping("/api/public/categories/{id}")
    public String updateCategory(@RequestBody Category category, @PathVariable Long id){
        Category category1 = categoriesService.updateCategory(category, id);
        return "Successfully updated the category with " + category1.getCategoryId();
    }
}
