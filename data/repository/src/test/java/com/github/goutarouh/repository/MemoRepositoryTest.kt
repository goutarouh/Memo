package com.github.goutarouh.repository

import com.github.goutarouh.remote.MemoRemoteReadOnlyModel
import com.github.goutarouh.remote.MemoRemoteService
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

class MemoRepositoryTest {

    @Test
    fun getMemoListTest() = runTest {
        val memoRepository = MemoRepository(
            memoRemoteService = FakeMemoRemoteService(),
            scope = this
        )
        val memoList = memoRepository.getMemoList()
        assertEquals(1, memoList.size)
    }

}


class FakeMemoRemoteService : MemoRemoteService {
    override suspend fun getMemos(): List<MemoRemoteReadOnlyModel> {
        return listOf(
            MemoRemoteReadOnlyModel(
                id = "2",
                title = "title2",
            ),
        )
    }
}