package com.baharudin.newsapp.db

import android.content.Context
import androidx.room.*
import com.baharudin.newsapp.model.Article

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converter::class)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun getArticleDao():ArticleDao
    companion object {
        @Volatile
        private var instance : ArticleDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it}
        }

        private fun createDatabase(context : Context) = Room.databaseBuilder(
            context.applicationContext,ArticleDatabase::class.java,"article_db.db"
        ).build()
    }
}