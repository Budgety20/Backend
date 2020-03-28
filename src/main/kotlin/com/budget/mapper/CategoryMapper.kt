package com.budget.mapper

import com.budget.dto.Category as CategoryDto
import com.budget.service.model.Category as CategoryModel

object CategoryMapper {
    fun map(categries: List<CategoryModel>) : List<CategoryDto>{
        return categries.map{map(it)}
                .toList()
    }

    private fun map(categoryModel: CategoryModel) : CategoryDto {
        var categoryDto = CategoryDto(categoryModel.code, categoryModel.name)
        categoryDto.description = categoryModel.description
        return categoryDto
    }
}