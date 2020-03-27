package com.budgety.controller

import com.budgety.service.CategoryService
import com.budgety.service.model.Category
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CategoryControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @MockBean
    lateinit var categoryService: CategoryService

    @Test
    fun it_should_fetch_all_category() {
        Mockito.`when`(categoryService.getCategory()).
                thenReturn(listOf(Category("test","test val")));
        val entity = restTemplate.getForEntity<String>("/category")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        Mockito.verify(categoryService,times(1)).getCategory();
    }

    @Test
    fun it_should_fetch_two_category() {
        Mockito.`when`(categoryService.getCategory()).
                thenReturn(getCategories());
        val entity = restTemplate.getForEntity<String>("/category")

        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).isEqualTo("[{\"code\":\"code1\",\"name\":\"test Name\",\"description\":\"\"},{\"code\":\"code2\",\"name\":\"test Name2\",\"description\":\"\"}]")
        Mockito.verify(categoryService,times(1)).getCategory();

    }

    fun getCategories(): List<Category> {
        return listOf(Category("code1","test Name"),
                Category("code2","test Name2"))
    }

}
