package com.github.goutarouh.repository.di

import com.github.goutarouh.remote.MemoRemoteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Singleton
    @Provides
    fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(5L, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun retrofit(
        repositoryConfig: RepositoryConfig,
        okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(repositoryConfig.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun memoRemoteService(
        retrofit: Retrofit,
    ): MemoRemoteService {
        return retrofit.create(MemoRemoteService::class.java)
    }
}