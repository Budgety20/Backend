package com.budgety.adapter.schema

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Category(@Id val code:String, val name:String)
