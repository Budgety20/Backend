package com.budgety.adapters.schema

import org.springframework.data.mongodb.core.mapping.Document

@Document("Category")
class Category(val code: String, val name: String) {
    var description = ""
}