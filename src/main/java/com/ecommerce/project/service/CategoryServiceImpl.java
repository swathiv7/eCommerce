package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private List<Category> categories = new ArrayList<>();
    private Long categoryIDValue = 1L;
    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void addCategories(Category category) {
        category.setCategoryId(categoryIDValue++);
        categories.add(category);
    }

    @Override
    public void deleteCategory(Long id) {
        boolean removed = categories.removeIf(
                c -> c.getCategoryId().equals(id)
        );

        if (!removed) {
            throw new RuntimeException("Category not found with id: " + id);
        }
    }


    @Override
    public Category updateCategory(Category category, Long id) {
        Category existingCategory = categories.stream()
                .filter(c -> c.getCategoryId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Category not found with id: " + id)
                );

        existingCategory.setCategoryName(category.getCategoryName());
        return existingCategory;
    }
}
