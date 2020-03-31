package com.budgety.adapters

import com.budgety.adapters.schema.Category
import org.springframework.data.mongodb.repository.MongoRepository


interface CategoryMongoAdapter : MongoRepository<Category, String>