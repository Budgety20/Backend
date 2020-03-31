package com.budgety.controller

import com.budgety.BudgetApplication
import com.budgety.adapters.MongoDbAdapter
import com.budgety.service.CategoryService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import com.budgety.dto.Category as CategoryDto
import com.budgety.service.model.Category as CategoryModel

@SpringBootTest(classes = arrayOf(BudgetApplication::class) ,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CategoryControllerTests() {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @MockBean
    lateinit var mongoDbAdapter: MongoDbAdapter

    @BeforeEach
    fun setUp(){
        Mockito.`when`(mongoDbAdapter.getAllCategory())
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