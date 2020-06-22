package com.baharudin.newsapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baharudin.newsapp.model.NewsResponse
import com.baharudin.newsapp.repository.NewsRepository
import com.baharudin.newsapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    val newRepository : NewsRepository
) : ViewModel() {

    val breakingNews : MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    val breakinNewsPage = 1

    init {
        getBreakingNews("us")
    }

    fun getBreakingNews(countryCode : String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response = newRepository.getBreakingNews(countryCode,breakinNewsPage)
        breakingNews.postValue(handleBreakingNewsResponse(response))
    }
    private fun handleBreakingNewsResponse(response: Response<NewsResponse>) : Resource<NewsResponse>{
        if (response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Succes(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}