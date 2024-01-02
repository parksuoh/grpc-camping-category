package com.example.category.applications;

import com.example.category.domains.Category;
import com.example.category.exceptions.CategoryNotExist;
import com.example.category.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteCategoryService {

    private final CategoryRepository categoryRepository;


    public DeleteCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(CategoryNotExist::new);

        categoryRepository.delete(category);

        return "success";
    }



}
