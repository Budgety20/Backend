package com.budgety.adapters

import com.budgety.service.model.Category
import org.springframework.stereotype.Service

@Service
class MongoDbAdapter(val simpleAdapter: SimpleAdapter) {
    fun getAllCategory(): List<Category> {
        return simpleAdapter.findAll().map { it -> Category(it.Code,it.Name) }.toList();
    }
}

