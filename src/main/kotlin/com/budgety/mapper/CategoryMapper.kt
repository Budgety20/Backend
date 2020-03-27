package com.budgety.mapper

import com.budgety.dto.CategoryDto
import com.budgety.service.model.Category;
import java.util.stream.Collectors

object  CategoryMapper {
     fun map(categories: List<Category>): List<CategoryDto>{
        return categories.map{map(it)}
                .toList();
    }

    private fun map(category : Category) : CategoryDto{
        var categoryDto =  CategoryDto(category.code,category.name)
        categoryDto.description = category.description
        return categoryDto
    }
}