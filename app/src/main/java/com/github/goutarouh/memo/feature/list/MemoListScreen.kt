package com.github.goutarouh.memo.feature.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.goutarouh.memo.UiState
import com.github.goutarouh.memo.error.SnackbarMessageEffect


//const val MAIN_SCREEN_LOADING_TAG = "MAIN_SCREEN_LOADING_TAG"
const val MAIN_SCREEN_SUCCESS_TAG = "MAIN_SCREEN_SUCCESS_TAG"
//const val MAIN_SCREEN_FAILURE_TAG = "MAIN_SCREEN_FAILURE_TAG"

@Composable
fun MemoListScreen(
    viewModel: MemoListViewModel = viewModel(),
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }

    SnackbarMessageEffect(
        snackbarHostState = snackbarHostState,
        userMessageStateHolder = viewModel.userMessageStateHolder
    )

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState)}
    ) { paddingValue ->
        MemoListScreen(
            uiState = uiState,
            modifier = Modifier.padding(paddingValue)
        )
    }
}

@Composable
private fun MemoListScreen(
    uiState: UiState<MemoListUiModel>,
    modifier: Modifier = Modifier
) {
    when (uiState) {
        is UiState.Loading -> {
        }
        is UiState.Success -> {
            MemoList(
                memoList = uiState.data.memoList,
                modifier = modifier
                    .background(Color.LightGray)
                    .testTag(MAIN_SCREEN_SUCCESS_TAG),
            )
        }
        is UiState.Error -> {
        }
    }
}