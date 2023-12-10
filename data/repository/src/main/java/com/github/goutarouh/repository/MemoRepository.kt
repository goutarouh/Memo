package com.github.goutarouh.repository

import android.util.Log
import com.github.goutarouh.remote.MemoRemoteService
import com.github.goutarouh.repository.di.Memo
import com.github.goutarouh.repository.di.toMemo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers



class MemoRepository(
    private val memoRemoteService: MemoRemoteService,
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.IO),
) {

    suspend fun getMemoList(): List<Memo> {
        return memoRemoteService.getMemos().map { it.toMemo() }
    }

}