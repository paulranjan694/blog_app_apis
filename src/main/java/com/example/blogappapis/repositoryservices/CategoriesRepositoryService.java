package com.example.blogappapis.repositoryservices;

import com.example.blogappapis.dto.Category;

import java.util.List;


public interface CategoriesRepositoryService {
    Category createCategory(Category category);
    Category updateCategory(Category category, Integer categoryId);
    String deleteCatrgory(Integer categoryId);
    Category getCategory(Integer categoryId);
    List<Category> getAllCategories();
}
