package com.github.goutarouh.memo.di

import com.github.goutarouh.memo.BuildConfig
import com.github.goutarouh.repository.di.RepositoryConfig
import com.github.goutarouh.repository.di.RepositoryModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun repositoryConfig(): RepositoryConfig {
        return RepositoryConfig(
            debug = BuildConfig.DEBUG,
            baseUrl = "http://10.0.2.2:3000/"
        )
    }

}