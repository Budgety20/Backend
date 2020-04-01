package com.budgety.mapper

import com.budgety.dto.Category as CategoryDto
import com.budgety.service.model.Category as CategoryModel

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

    fun map(categoryDto: CategoryDto) : CategoryModel {
        var categoryModel = CategoryModel(categoryDto.code, categoryDto.name)
        categoryModel.description = categoryDto.description
        return categoryModel
    }
}