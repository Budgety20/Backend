package com.budgety.adapters

import org.springframework.data.mongodb.core.mapping.Document

@Document("Category")
class Category(val Code: String, val Name: String) {
}