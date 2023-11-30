package ir.divar.androidtask.feature.postDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.divar.androidtask.data.model.Result
import ir.divar.androidtask.data.repository.PostRepository
import ir.divar.androidtask.feature.generic.PostDetailsUiState
import ir.divar.androidtask.feature.post.PostMapper.toPostDetailsData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(val repository: PostRepository) : ViewModel() {

    private var _postDetailsUiState = MutableStateFlow(PostDetailsUiState())
    val postDetailsUiState = _postDetailsUiState.asStateFlow()


    fun launchPostDetails(token: String?) {
        viewModelScope.launch {
            when (val result = repository.getPostView(ACCESS_TOKEN, token)) {
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

    companion object {
        const val ACCESS_TOKEN =
            "Basic YXBpa2V5OjY5Y1dxVW8wNGhpNFdMdUdBT2IzMmRXZXQjsllsVzBtSkNiwU9yLUxEamNDUXFMSzJnR29mS3plZg=="
    }
}