package com.example.newsapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.Date


@Entity
data class Article (
    @PrimaryKey
    val id:String,

    @ColumnInfo(name = "publisher")
    val publisher:String,

    var topic: String ,

    var content: String?,

    val datePublished:Date = Date()
)