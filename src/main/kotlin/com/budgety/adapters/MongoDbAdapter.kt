package com.budgety.adapters

import com.budgety.service.model.Category
import org.springframework.stereotype.Service
import com.budgety.adapters.schema.Category as CategoryDao

@Service
class MongoDbAdapter(val simpleAdapter: CategoryMongoAdapter) {
    fun getAllCategory(): List<Category> {
        return simpleAdapter.findAll().map { map(it) }.toList();
    }

    fun map(categoryDao: CategoryDao) : Category {
        var category = Category(categoryDao.code,categoryDao.name)
        category.description = categoryDao.description
        return category
    }
}

