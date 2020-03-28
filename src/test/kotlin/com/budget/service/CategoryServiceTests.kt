package com.budget.service

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CategoryServiceTests(@Autowired val categoryService: CategoryService) {
    @Test
    fun it_should_get_non_empty_category_list(){
        var categories = categoryService.getAllCategories()
        assertThat(categories).isNotNull()
    }
}