package com.budget.controller

import com.budget.dto.Category
import com.budget.mapper.CategoryMapper
import com.budget.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/category")
class CategoryController {

    @Autowired
    lateinit var categoryService: CategoryService

    @GetMapping
    fun getCategory(): List<Category> {
        var categories = categoryService.getAllCategories();
        return CategoryMapper.map(categories);
    }
}