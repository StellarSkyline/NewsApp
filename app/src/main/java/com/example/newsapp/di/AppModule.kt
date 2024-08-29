package com.example.newsapp.di

import android.app.Application
import com.example.newsapp.data.BaseValues
import com.example.newsapp.data.MyAPI
import com.example.newsapp.data.NetworkHelper.interceptor
import com.example.newsapp.data.repo.AllNewsRepoImpl
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesMyApi():MyAPI {
        return Retrofit.Builder()
            .baseUrl(BaseValues.baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(interceptor)
            .build()
            .create(MyAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesAllNewsRepo(api:MyAPI):AllNewsRepoImpl = AllNewsRepoImpl(api)


}