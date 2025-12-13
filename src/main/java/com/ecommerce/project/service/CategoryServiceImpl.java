package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        for (Category eachCategories: categories) {
            if(eachCategories.getCategoryId().equals(id)){
                categories.remove(eachCategories);
            }
        }
    }
}
