package com.github.goutarouh.memo.feature.list

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.goutarouh.memo.UiState

@Composable
fun MemoListScreen(
    viewModel: MemoListViewModel = viewModel(),
) {
    when (val uiState = viewModel.uiState.collectAsStateWithLifecycle().value) {
        is UiState.Loading -> {
        }
        is UiState.Success -> {
            MemoList(
                uiState.data.memoList
            )
        }
        is UiState.Error -> {
        }
    }
}