package com.budgety.adapters

import org.springframework.data.mongodb.repository.MongoRepository


interface SimpleAdapter : MongoRepository<Category, String>