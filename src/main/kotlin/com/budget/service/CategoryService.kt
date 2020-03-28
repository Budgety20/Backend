package com.budget.service

import com.budget.service.model.Category
import org.springframework.stereotype.Service


@Service
class CategoryService {
    fun getAllCategories() : List<Category> {
        return listOf<Category>();
    }

}