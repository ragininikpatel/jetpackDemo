package com.example.jetpackdemo.api

import com.example.jetpackdemo.models.tweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface tweestyApi {

    @GET("/v3/b/65043646d972192679c45702?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path")category: String) : Response<List<tweetListItem>>

    @GET("/v3/b/65043646d972192679c45702?meta=false")
    @Headers("X-JSON-Path : tweets..category")
    suspend fun getCategories() : Response<List<String>>
}