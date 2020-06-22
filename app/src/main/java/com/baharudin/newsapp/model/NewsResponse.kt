package com.baharudin.newsapp.model

import com.baharudin.newsapp.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)