package com.budgety.service

import com.budgety.adapters.MongoDbAdapter
import com.budgety.service.model.Category
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.any
import org.mockito.Mockito.times
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class CategoryServiceTests(@Autowired val categoryService: CategoryService) {

    @MockBean
    lateinit var mongoDbAdapter:MongoDbAdapter;

    @Test
    fun it_should_get_non_empty_category_list(){
        var categories = categoryService.getAllCategories()
        assertThat(categories).isNotNull()
    }

    @Test
    fun it_should_create_new_category(){
        val category = Category("code1","test name1")
        Mockito.doNothing().`when`(mongoDbAdapter).createCategory(category)
        categoryService.createCategory(category)
        Mockito.verify(mongoDbAdapter,times(1)).createCategory(category)
    }
}