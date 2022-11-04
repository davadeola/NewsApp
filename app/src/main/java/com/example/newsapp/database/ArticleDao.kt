package com.example.newsapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ArticleDao {

    @Query("SELECT * FROM article")
    fun getAll():List<Article>

    @Insert
    suspend fun insert(article: Article)

    @Delete
    fun delete(article:Article)


}