package com.github.goutarouh.repository.di

import com.github.goutarouh.remote.MemoRemoteReadOnlyModel

data class Memo (
    val id: String,
    val title: String,
)

internal fun MemoRemoteReadOnlyModel.toMemo(): Memo {
    return Memo(
        id = id,
        title = title,
    )
}
