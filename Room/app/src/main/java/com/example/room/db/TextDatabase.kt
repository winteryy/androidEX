package com.example.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room.entity.TextEntity
import com.example.room.dao.TextDAO
import com.example.room.dao.WordDAO
import com.example.room.entity.WordEntity

@Database(entities = [TextEntity::class, WordEntity::class], version = 2)
abstract class TextDatabase: RoomDatabase() {

    abstract fun textDAO(): TextDAO
    abstract fun wordDAO(): WordDAO

    companion object{
        @Volatile
        private var INSTANCE: TextDatabase? = null

        fun getDatabase(
            context: Context
        ): TextDatabase {
            return INSTANCE ?: synchronized(this){

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TextDatabase::class.java,
                    "text_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }

}