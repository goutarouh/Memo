package com.github.goutarouh.test.testdi

import com.github.goutarouh.remote.MemoRemoteReadOnlyModel
import com.github.goutarouh.remote.MemoRemoteService
import com.github.goutarouh.remote.di.RemoteModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RemoteModule::class]
)
object TestRemoteModule {

    @Singleton
    @Provides
    fun memoRemoteService(): MemoRemoteService {
        return object : MemoRemoteService {
            override suspend fun getMemos(): List<MemoRemoteReadOnlyModel> {
                return List(5) {
                    MemoRemoteReadOnlyModel(
                        id = it.toString(),
                        title = "aaaja-fake-title$it",
                    )
                }
            }

        }
    }
}