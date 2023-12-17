package com.github.goutarouh.repository

import com.github.goutarouh.remote.MemoRemoteService
import com.github.goutarouh.repository.di.Memo
import com.github.goutarouh.repository.di.toMemo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


class MemoRepository @Inject constructor(
    val memoRemoteService: MemoRemoteService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {

    suspend fun getMemoList(): List<Memo> {
        return memoRemoteService.getMemos().map { it.toMemo() }
    }

}