package com.example.jetpackdemo.di

import com.example.jetpackdemo.api.tweestyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl("https://api.jsonbin.io/")
            .addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Singleton
    @Provides
    fun provideTweestyApi(retrofit: Retrofit): tweestyApi{
        return retrofit.create(tweestyApi::class.java)
    }
}