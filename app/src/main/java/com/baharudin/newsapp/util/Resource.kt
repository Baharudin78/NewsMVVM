package com.baharudin.newsapp.util

sealed class Resource <T>(
    val data: T? = null,
    val massage : String? = null
) {
    class Succes<T>(data: T) : Resource<T>(data)
    class Error<T>(massage: String ,data: T? = null) : Resource<T>(data,massage)
    class Loading<T> : Resource<T>()
}