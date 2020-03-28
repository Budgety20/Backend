package com.budget.adapters

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.assertThat

@SpringBootTest
class MongoDbAdapterTests(@Autowired val mongoDbAdapter: MongoDbAdapter) {

    @Test
    fun it_should_fetch_category(){

        var categories = mongoDbAdapter.getAllCategory();

        assertThat(categories).isNotEmpty()
        assertThat(categories).isNotNull()
    }
}