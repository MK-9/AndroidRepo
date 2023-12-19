package ir.divar.postdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.divar.androidtask.data.network.models.Result
import ir.divar.data.repository.PostRepository
import ir.divar.androidtask.feature.generic.uiState.PostDetailsUiState
import ir.divar.androidtask.feature.post.PostUIMapper.toPostDetailsData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle, private val repository: ir.divar.data.repository.PostRepository
) : ViewModel() {

    private var _postDetailsUiState = MutableStateFlow(PostDetailsUiState())
    val postDetailsUiState = _postDetailsUiState.asStateFlow()

    private val token = checkNotNull(savedStateHandle.get<String>("token"))

    init {
        launchPostDetails(token)
    }

    fun launchPostDetails(token: String?) {
        viewModelScope.launch {
            repository.getPostView(token).collectLatest { result ->
                when (result) {
                    is Result.InProgress -> {
                        _postDetailsUiState.update { currentState ->
                            currentState.copy(isLoading = true)
                        }
                    }

                    is Result.OnSuccess -> {
                        _postDetailsUiState.update { currentState ->
                            currentState.copy(
                                isLoading = false, data = result.data.toPostDetailsData()
                            )
                        }
                    }

                    is Result.OnError -> {
                        _postDetailsUiState.update { currentState ->
                            currentState.copy(isLoading = false)
                        }
                    }
                }
            }
        }
    }
}