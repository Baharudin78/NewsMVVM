package com.baharudin.newsapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    //membuat nama table
    tableName = "articles"
)

data class Article(
    //menjadikan id sebagai primary key
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)