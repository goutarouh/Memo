package com.github.goutarouh.memo.feature.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.goutarouh.memo.UiState
import com.github.goutarouh.repository.MemoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemoListViewModel @Inject constructor(
    memoRepository: MemoRepository,
): ViewModel() {

    private val _uiState = MutableStateFlow<UiState<MemoListUiModel>>(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val memoList = memoRepository.getMemoList()
                _uiState.value = UiState.Success(MemoListUiModel(memoList))
            } catch (e: CancellationException) {
                throw e
            } catch (e: Throwable) {
                _uiState.value = UiState.Error(e)
            }
        }
    }

}