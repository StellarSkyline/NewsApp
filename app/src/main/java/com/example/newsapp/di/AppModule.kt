/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.di

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.newsapp.data.BaseValues
import com.example.newsapp.data.repo.AllNewsRepoImpl
import com.example.newsapp.data.repo.PhotosRepoImpl
import com.example.newsapp.domain.MyAPI
import com.example.newsapp.domain.NetworkHelper.newsInterceptor
import com.example.newsapp.domain.NetworkHelper.photosInterceptor
import com.example.newsapp.domain.PexelAPI
import com.example.newsapp.domain.repo.AllNewsRepo
import com.example.newsapp.domain.repo.PhotosRepo
import com.example.newsapp.room.NewsDao
import com.example.newsapp.room.NewsDatabase
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesMyApi(): MyAPI {
        return Retrofit.Builder()
            .baseUrl(BaseValues.newsUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(newsInterceptor)
            .build()
            .create(MyAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesPhotosRepoAPI(): PexelAPI {
        return Retrofit.Builder()
            .baseUrl(BaseValues.pexelUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(photosInterceptor)
            .build()
            .create(PexelAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesNewsDatabase(@ApplicationContext app: Context): NewsDatabase =
        Room.databaseBuilder(app, NewsDatabase::class.java, "news_database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providesAllNewsRepo(api: MyAPI, db: NewsDatabase): AllNewsRepo = AllNewsRepoImpl(api, db)

    @Provides
    @Singleton
    fun providesPhotosRepo(api: PexelAPI ): PhotosRepo = PhotosRepoImpl(api)

}