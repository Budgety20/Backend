package com.budgety.service

import com.budgety.adapters.MongoDbAdapter
import com.budgety.service.model.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class CategoryService() {

    @Autowired
    lateinit var mongoDbAdapter: MongoDbAdapter

    fun getAllCategories() : List<Category> {
        return mongoDbAdapter.getAllCategory()
    }

    fun createCategory(category: Category) {
        return mongoDbAdapter.createCategory(category)
    }
}