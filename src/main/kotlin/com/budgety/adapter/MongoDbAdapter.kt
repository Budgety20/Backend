package com.budgety.adapter

import com.budgety.adapter.dao.CategoryDAO
import com.budgety.service.model.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MongoDbAdapter(){

    @Autowired
    lateinit var categoryDAO: CategoryDAO

    fun getAll() : List<Category> {
        return categoryDAO.findAll().map { Category(it.code,it.name) }.toList()
    }
}