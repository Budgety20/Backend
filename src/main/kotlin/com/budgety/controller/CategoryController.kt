package com.budgety.controller

import com.budgety.dto.Category
import com.budgety.mapper.CategoryMapper
import com.budgety.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

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

    @PostMapping
    fun createCategory(@Valid @RequestBody category: Category) {
        categoryService.createCategory(CategoryMapper.map(category))
    }
}