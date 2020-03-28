package com.budgety.controller

import com.budgety.service.CategoryService
import com.budgety.service.model.Category as CategoryModel
import com.budgety.dto.Category as CategoryDto
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CategoryControllerTests(@Autowired val restTemplate: TestRestTemplate) {

    @MockBean
    lateinit var categoryService: CategoryService

    @BeforeEach
    fun setUp(){
        Mockito.`when`(categoryService.getAllCategories())
                .thenReturn(getDummyCategory())
    }

    @Test
    fun  it_should_return_ok_status(){
        var entity = restTemplate.getForEntity<List<CategoryDto>>("/category")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
    }

    @Test
    fun  it_should_return_single_category_dto(){
        var entity = restTemplate.getForEntity<List<CategoryDto>>("/category")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).size().isEqualTo(1)
    }

    private fun getDummyCategory(): List<CategoryModel>{
        var categoryModel = CategoryModel("C01", "Food");
        categoryModel.description = "Expenses on the food related items";

        return listOf(categoryModel)
    }
}