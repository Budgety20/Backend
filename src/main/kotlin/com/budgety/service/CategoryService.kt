package com.budgety.service

import com.budgety.service.model.Category
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryService {
    fun getCategory(): List<Category> {
       return listOf(Category("test","test val"));
    }
}
