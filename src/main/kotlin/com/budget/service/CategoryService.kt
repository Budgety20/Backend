package com.budget.service

import com.budget.adapters.MongoDbAdapter
import com.budget.service.model.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class CategoryService(@Autowired val mongoDbAdapter: MongoDbAdapter) {

    fun getAllCategories() : List<Category> {

        return mongoDbAdapter.getAllCategory();

    }
}