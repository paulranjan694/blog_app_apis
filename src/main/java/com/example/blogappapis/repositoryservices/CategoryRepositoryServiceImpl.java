package com.example.blogappapis.repositoryservices;

import com.example.blogappapis.dto.Category;
import com.example.blogappapis.entities.CategoryEntity;
import com.example.blogappapis.exceptions.ResourceNotFoundException;
import com.example.blogappapis.repositories.CategoryRepository;
import jakarta.inject.Provider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryRepositoryServiceImpl implements CategoriesRepositoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    @Override
    public Category createCategory(Category category) {
        CategoryEntity categoryEntity = modelMapperProvider.get().map(category,CategoryEntity.class);
        CategoryEntity createdCategory = categoryRepository.save(categoryEntity);
        Category categorytobeReturned = modelMapperProvider.get().map(categoryEntity,Category.class);
        return categorytobeReturned;
    }

    @Override
    public Category updateCategory(Category category, Integer categoryId) {
        CategoryEntity cat = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(String.format("Category not found with id - %s",categoryId)));
        cat.setCategoryTitle(category.getCategoryTitle());
        cat.setCategoryDescription(category.getCategoryDescription());

        CategoryEntity catUpdated = categoryRepository.save(cat);
        Category returnCat = modelMapperProvider.get().map(catUpdated, Category.class);
        return returnCat;
    }

    @Override
    public String deleteCatrgory(Integer categoryId) {
        CategoryEntity cat = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(String.format("Category not found with id - %s",categoryId)));
        categoryRepository.delete(cat);
        return String.format("Category deleted with id - %s", cat.getCategoryId());
    }

    @Override
    public Category getCategory(Integer categoryId) {
        CategoryEntity cat = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(String.format("Category not found with id - %s",categoryId)));
        Category category = modelMapperProvider.get().map(cat, Category.class);
        return category;
    }

    @Override
    public List<Category> getAllCategories() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        ModelMapper modelMapper = modelMapperProvider.get();
        List<Category> categories = categoryEntities.stream().map(cat -> modelMapper.map(cat,Category.class)).collect(Collectors.toList());
        return categories;
    }
}
