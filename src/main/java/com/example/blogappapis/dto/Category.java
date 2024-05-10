package com.example.blogappapis.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Category {
    private Integer categoryId;
    @NotBlank
    @Size(min = 4,message = "Min size of category title is 4")
    private String categoryTitle;

    @NotBlank
    @Size(min = 10, message = "min size of cateogry desc is 10")
    private String categoryDescription;
}
