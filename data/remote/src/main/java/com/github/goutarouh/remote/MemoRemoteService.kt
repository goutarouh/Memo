package com.github.goutarouh.remote

import retrofit2.http.GET

interface MemoRemoteService {

    @GET("getMemos")
    suspend fun getMemos(): List<MemoRemoteReadOnlyModel>
}