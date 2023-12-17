package com.github.goutarouh.repository.di

import com.github.goutarouh.remote.MemoRemoteService
import com.github.goutarouh.remote.di.RemoteConfig
import com.github.goutarouh.repository.MemoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun remoteConfig(
        repositoryConfig: RepositoryConfig
    ): RemoteConfig {
        return RemoteConfig(
            debug = repositoryConfig.debug,
            baseUrl = repositoryConfig.baseUrl
        )
    }

    @Singleton
    @Provides
    fun memoRepository(
        memoRemoteService: MemoRemoteService
    ): MemoRepository {
        return MemoRepository(
            memoRemoteService = memoRemoteService
        )
    }

}