package com.budgety.adapter.dao

import com.budgety.adapter.schema.Category
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

/*Spring does the implementation for us*/


@Repository
interface CategoryDAO:MongoRepository<Category,String>