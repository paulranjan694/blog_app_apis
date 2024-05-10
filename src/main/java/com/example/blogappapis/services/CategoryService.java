package com.example.blogappapis.services;

import com.example.blogappapis.dto.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);
    Category updateCategory(Category category, Integer categoryId);
    String deleteCategory(Integer categoryId);
    Category getCategory(Integer categoryId);
    List<Category> getAllCategories();
}
