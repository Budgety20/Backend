package com.budgety.service

import com.budgety.adapter.MongoDbAdapter
import com.budgety.adapter.dao.CategoryDAO
import com.budgety.service.model.Category
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryService(val mongoDbAdapter: MongoDbAdapter) {
    fun getCategory(): List<Category> {
       return  mongoDbAdapter.getAll();
    }
}
