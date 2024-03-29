package com.example.category.applications;

import com.example.category.domains.Category;
import com.example.category.dtos.CategoryItemDto;
import com.example.category.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GetCategoryService {

    private final CategoryRepository categoryRepository;


    public GetCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryItemDto> getCategories() {


        List<Category> categories = categoryRepository.findAll();

        return categories
                .stream()
                .map(category -> new CategoryItemDto(category.id(), category.name().toString()))
                .toList();

    }

}
