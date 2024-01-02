package com.example.category.controllers;


import com.example.category.applications.GetCategoryService;
import com.example.category.dtos.CategoryItemDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/category/common")
public class CategoryController {

    private final GetCategoryService getCategoryService;

    public CategoryController(GetCategoryService getCategoryService) {
        this.getCategoryService = getCategoryService;
    }

    @GetMapping
    public List<CategoryItemDto> get() {
        return getCategoryService.getCategories();
    }
}
