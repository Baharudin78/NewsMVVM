package com.baharudin.newsapp.api

import com.baharudin.newsapp.model.NewsResponse
import com.baharudin.newsapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode : String ="us",
        @Query("page")
        pageNumber:Int = 1,
        @Query("api key")
        apiKey: String = API_KEY
    ):Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery : String ,
        @Query("page")
        pageNumber:Int = 1,
        @Query("api key")
        apiKey: String = API_KEY
    ):Response<NewsResponse>
}