package com.example.category.dtos;

public record AuthUserDto(
        String name,
        String role,
        String accessToken
) {}
