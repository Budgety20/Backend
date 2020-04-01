package com.budgety.adapters

import com.budgety.service.model.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.budgety.adapters.schema.Category as CategoryDao

@Service
class MongoDbAdapter(@Autowired val categoryMongoAdapter : CategoryMongoAdapter) {
    fun getAllCategory(): List<Category> {
        return categoryMongoAdapter.findAll().map { map(it) }.toList()
    }

    fun map(categoryDao: CategoryDao) : Category {
        val category = Category(categoryDao.code,categoryDao.name)
        category.description = categoryDao.description
        return category
    }

    fun createCategory(category: Category) {
        categoryMongoAdapter.save(map(category))
    }

    fun map(category: Category) : CategoryDao {
        val categoryDao = CategoryDao(category.code,category.name)
        categoryDao.description = category.description
        return categoryDao
    }
}

