package com.baharudin.newsapp.repository

import com.baharudin.newsapp.api.RetrofitInstance
import com.baharudin.newsapp.db.ArticleDatabase
import retrofit2.Retrofit

class NewsRepository(
    val db :  ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode : String , pageNumber : Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)
}