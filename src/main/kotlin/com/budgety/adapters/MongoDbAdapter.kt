package com.budgety.adapters

import com.budgety.ApplicationConfig
import com.budgety.service.model.Category
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.MongoException
import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MongoDbAdapter(@Autowired val appConfig: ApplicationConfig) {

    fun getMongoClient() : MongoClient {
        var mongoClient: MongoClient? = null
        var uri = appConfig?.mongoUri?.let { MongoClientURI(it) }
        try{
            mongoClient = uri?.let { MongoClient(it) }
        }catch (e: MongoException){
            e.printStackTrace()
        }
        return mongoClient!!;
    }

    fun getAllCategory(): List<Category> {
        var mongoClient = getMongoClient();
        var database = appConfig.databaseName?.let { mongoClient.getDatabase(it) };
        var collection = database?.getCollection("Category", Document::class.java);

        val result = ArrayList<Category>()

        collection?.find()?.forEach{
            val category: Category = mongoDocumentToMap(it)
            result.add(category);
        }

        return result;
    }

    fun mongoDocumentToMap(document: Document) : Category {
        val asMap: MutableMap<String,Any> = document.toMutableMap();
        var code = asMap.getValue("Code") as String
        var name = asMap.getValue("Name") as String
        return Category(code,name);
    }
}

