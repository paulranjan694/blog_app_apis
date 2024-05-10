package com.example.blogappapis.controllers;

import com.example.blogappapis.dto.Category;
import com.example.blogappapis.exchanges.ExceptionResponse;
import com.example.blogappapis.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    
        @PostMapping("/categories")
        public ResponseEntity<Category> createCategory(@Valid @RequestBody Category cateogDto) {
            Category createCategory = categoryService.createCategory(cateogDto);
            return new ResponseEntity<Category>(createCategory, HttpStatus.CREATED);
        }


        @PutMapping("/categories/{catId}")
        public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category Category,
                                                          @PathVariable Integer catId) {
            Category updatedCategory = categoryService.updateCategory(Category, catId);
            return new ResponseEntity<Category>(updatedCategory, HttpStatus.OK);
        }

        @DeleteMapping("/categories/{catId}")
        public ResponseEntity<String> deleteCategory(@PathVariable Integer catId) {
        String res = categoryService.deleteCategory(catId);
            return new ResponseEntity<String>(res,HttpStatus.OK);
        }

        @GetMapping("/categories/{catId}")
        public ResponseEntity<Category> getCategory(@PathVariable Integer catId) {
            Category Category = categoryService.getCategory(catId);
            return new ResponseEntity<Category>(Category, HttpStatus.OK);

        }

        @GetMapping("/categories")
        public ResponseEntity<List<Category>> getCategories() {
            List<Category> categories = categoryService.getAllCategories();
            return ResponseEntity.ok(categories);
        }
        
}
