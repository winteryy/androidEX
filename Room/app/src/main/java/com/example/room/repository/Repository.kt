package com.example.room.repository

import android.content.Context
import com.example.room.db.TextDatabase
import com.example.room.entity.TextEntity
import com.example.room.entity.WordEntity

class Repository(context: Context) {

    val db = TextDatabase.getDatabase(context)

    fun getTextList() = db.textDAO().getAllData()
    fun getWordList() = db.wordDAO().getAllData()

    fun insertTextData(text: String) = db.textDAO().insert(TextEntity(0, text))
    fun insertWordData(text: String) = db.wordDAO().insert(WordEntity(0, text))

    fun deleteTextData() = db.textDAO().deleteAllData()
    fun deleteWordData() = db.wordDAO().deleteAllData()
}