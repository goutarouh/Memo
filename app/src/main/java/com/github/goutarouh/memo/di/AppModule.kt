package com.github.goutarouh.memo.di

import com.github.goutarouh.memo.BuildConfig
import com.github.goutarouh.memo.error.UserMessageStateHolder
import com.github.goutarouh.memo.error.UserMessageStateHolderImpl
import com.github.goutarouh.repository.di.RepositoryConfig
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


    @Provides
    @Singleton
    fun provideMessageStateHolder(): UserMessageStateHolder {
        return UserMessageStateHolderImpl()
    }

}