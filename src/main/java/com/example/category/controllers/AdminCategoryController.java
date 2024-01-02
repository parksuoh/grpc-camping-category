package com.example.category.controllers;

import com.example.category.applications.AddCategoryService;
import com.example.category.applications.DeleteCategoryService;
import com.example.category.applications.GetAdminCategoriesService;
import com.example.category.dtos.AddCategoryRequestDto;
import com.example.category.dtos.CategoryItemDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/category/admin")
public class AdminCategoryController {

    private final GetAdminCategoriesService getAdminCategoriesService;
    private final AddCategoryService addCategoryService;
    private final DeleteCategoryService deleteCategoryService;

    public AdminCategoryController(GetAdminCategoriesService getAdminCategoriesService, AddCategoryService addCategoryService, DeleteCategoryService deleteCategoryService) {
        this.getAdminCategoriesService = getAdminCategoriesService;
        this.addCategoryService = addCategoryService;
        this.deleteCategoryService = deleteCategoryService;
    }

    @GetMapping
    public List<CategoryItemDto> get(){

        return getAdminCategoriesService.getCategories();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String post(@Valid @RequestBody AddCategoryRequestDto addCategoryRequestDto) {
        return addCategoryService.addCategory(addCategoryRequestDto.categoryName());
    }

    @DeleteMapping("/{categoryId}")
    public String delete(@PathVariable Long categoryId) {

        return deleteCategoryService.deleteCategory(categoryId);
    }

}

