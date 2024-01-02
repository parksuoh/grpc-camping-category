package com.example.category.applications;

import com.example.category.domains.Category;
import com.example.category.domains.Name;
import com.example.category.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class AddCategoryService {

    private final CategoryRepository categoryRepository;

    public AddCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public String addCategory(String name){

        Category category = new Category(new Name(name));

        categoryRepository.save(category);

        return "success";
    }
}
