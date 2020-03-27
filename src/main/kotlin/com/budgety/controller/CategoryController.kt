package com.budgety.controller

import com.budgety.dto.CategoryDto
import com.budgety.mapper.CategoryMapper
import com.budgety.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/category")
public class CategoryController{

    @Autowired
    lateinit var categoryService:CategoryService;


    @GetMapping
    fun getCategory(): List<CategoryDto> {
        return CategoryMapper.map(categoryService.getCategory())
    }
}