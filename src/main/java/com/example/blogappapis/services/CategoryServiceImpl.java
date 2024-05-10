package com.example.blogappapis.services;

import com.example.blogappapis.dto.Category;
import com.example.blogappapis.repositoryservices.CategoriesRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoriesRepositoryService categoriesRepositoryService;

    @Override
    public Category createCategory(Category category) {
        Category cat = categoriesRepositoryService.createCategory(category);
        return cat;
    }

    @Override
    public Category updateCategory(Category category, Integer categoryId) {
        Category cat = categoriesRepositoryService.updateCategory(category,categoryId);
        return cat;
    }

    @Override
    public String deleteCategory(Integer categoryId) {
        String resp = categoriesRepositoryService.deleteCatrgory(categoryId);
        return resp;
    }

    @Override
    public Category getCategory(Integer categoryId) {
        Category cat = categoriesRepositoryService.getCategory(categoryId);
        return cat;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> cat = categoriesRepositoryService.getAllCategories();
        return cat;
    }
}
