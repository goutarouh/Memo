package com.github.goutarouh.memo

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.goutarouh.repository.MemoRepository
import com.github.goutarouh.repository.di.Memo
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    //private val viewModel: MainViewModel by activity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("hasegawa", "${viewModel.hashCode()}")
        setContent {

            val uiState = viewModel.uiState.collectAsState().value
            when (uiState) {
                UiState.Loading -> {
                    Text(text = "Loading")
                }
                is UiState.Success -> {
                    Column {
                        uiState.memos.forEach {
                            Text(text = it.title)
                        }
                    }
                }
                is UiState.Error -> {
                    Text(text = uiState.message)
                }

            }
        }
    }
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val memoRepository: MemoRepository
): ViewModel() {

    val uiState = MutableStateFlow<UiState>(UiState.Loading)

    init {
        viewModelScope.launch {
            try {
                val memos = memoRepository.getMemoList()
                uiState.value = UiState.Success(memos)
            } catch (e: Exception) {
                uiState.value = UiState.Error(e.message ?: "Unknown Error")
            }
        }
    }

}

sealed interface UiState {
    object Loading: UiState
    data class Success(val memos: List<Memo>): UiState
    data class Error(val message: String): UiState
}
