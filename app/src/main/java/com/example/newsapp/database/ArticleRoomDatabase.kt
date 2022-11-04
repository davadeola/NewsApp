package com.example.newsapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Article::class], version = 1)
abstract class ArticleRoomDatabase:RoomDatabase() {

    abstract fun articleDao():ArticleDao


    companion object{
        private var articleRoomInstance: ArticleRoomDatabase? = null

        //ensures only one database in the entire application
        fun getDatabase(context: Context): ArticleRoomDatabase?{
            if (articleRoomInstance == null){
                synchronized(ArticleRoomDatabase::class.java){
                    if (articleRoomInstance == null){
                        articleRoomInstance = Room.databaseBuilder(
                            context.applicationContext, ArticleRoomDatabase::class.java, "article_database"
                        ).build()
                    }
                }
            }
            return articleRoomInstance
        }
    }
}