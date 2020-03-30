package com.budgety.adapters

import com.budgety.ApplicationConfig
import com.budgety.service.model.Category
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MongoDbAdapter(@Autowired val appConfig: ApplicationConfig) {

    fun getMongoClient() : MongoClient? {
        val uri = appConfig.mongoUri?.let { MongoClientURI(it) }
        return uri?.let { MongoClient(it) }
    }

    fun getAllCategory(): List<Category> {
        var mongoClient: MongoClient? = null
        val result = ArrayList<Category>()
        try {
            mongoClient = getMongoClient()
            val database = appConfig.databaseName?.let { mongoClient?.getDatabase(it) }
            val collection = database?.getCollection("Category", Document::class.java)
            collection?.find()?.forEach {
                val category: Category = mongoDocumentToMap(it)
                result.add(category)
            }
        } catch (e: Exception){
            e.printStackTrace()
        }
        finally {
            mongoClient!!.close()
        }

        return result
    }

    fun mongoDocumentToMap(document: Document) : Category {
        val asMap: MutableMap<String,Any> = document.toMutableMap()
        val code = asMap.getValue("Code") as String
        val name = asMap.getValue("Name") as String
        return Category(code,name)
    }
}

