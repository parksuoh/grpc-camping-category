package com.example.category.dtos;

import jakarta.validation.constraints.NotBlank;

public record AddCategoryRequestDto(
        @NotBlank
        String categoryName
) {}

