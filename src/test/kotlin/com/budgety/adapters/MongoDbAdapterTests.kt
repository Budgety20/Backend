package com.budgety.adapters

import com.budgety.service.model.Category
import com.mongodb.BasicDBObjectBuilder
import com.mongodb.DBObject
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.Spy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.SpyBean
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.test.context.ActiveProfiles

@DataMongoTest
class MongoDbAdapterTests() {

    @Autowired
    @Spy
    lateinit var categoryMongoAdapter: CategoryMongoAdapter

    private lateinit var mongoDbAdapter:MongoDbAdapter;

    @BeforeEach
    fun setUp() {
        mongoDbAdapter = MongoDbAdapter(categoryMongoAdapter);
    }


    @Test
    fun it_should_fetch_category(){

        var categories = mongoDbAdapter.getAllCategory();

        assertThat(categories).size().isGreaterThan(2)
    }

    @Test
    fun it_should_create_and_fetch_category(){
        val category = Category("code1","test name1")

        mongoDbAdapter.createCategory(category);

        var categories = mongoDbAdapter.getAllCategory();


        assertThat(categories).size().isGreaterThan(2)
        assertThat(categories).contains(category)
    }



}