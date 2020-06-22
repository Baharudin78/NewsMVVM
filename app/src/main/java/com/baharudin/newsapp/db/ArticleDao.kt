package com.baharudin.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.baharudin.newsapp.model.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article) : Long
    //mengambil data dari semua artikel
    @Query("SELECT * from articles")
    fun getAllArticle():LiveData<List<Article>>
    //menghapus article
    @Delete
    suspend fun deleteArticle(article: Article)
}