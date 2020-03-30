package com.budgety.adapters

import com.budgety.service.model.Category
import com.mongodb.*
import org.bson.Document
import org.springframework.stereotype.Service

@Service
class MongoDbAdapter {
    fun getMongoClient() : MongoClient {
        var uri = MongoClientURI("mongodb+srv://read-only:xwupN42IF64hIxL8@budgety-alatv.mongodb.net")
        return MongoClient(uri)
    }

    fun getAllCategory(): List<Category> {
        var mongoClient: MongoClient? = null
        val result = ArrayList<Category>()
        try {
            mongoClient = getMongoClient();
            var database = mongoClient.getDatabase("Budgety");
            var collection = database.getCollection("Category", Document::class.java);
            collection.find()
                    .forEach {
                        val category: Category = mongoDocumentToMap(it)
                        result.add(category);
                    }
        } catch (e: Exception){
            e.printStackTrace()
        }
        finally {
            mongoClient!!.close();
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

