package ir.divar.androidtask.feature.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.divar.androidtask.data.model.Result
import ir.divar.androidtask.data.model.request.PostListRequest
import ir.divar.androidtask.data.repository.PostRepository
import ir.divar.androidtask.feature.generic.uiState.PostsUiState
import ir.divar.androidtask.feature.post.PostMapper.toPostsData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(val repository: PostRepository) : ViewModel() {

    private var _postsUiState = MutableStateFlow(PostsUiState())
    val postsUiState = _postsUiState.asStateFlow()

    init {
        launchPosts(3)
    }

    fun launchPosts(cityId: Int) {
        viewModelScope.launch {
            val result = repository.getPostList(
                accessToken = ACCESS_TOKEN, selectedCityId = cityId, body = PostListRequest(0, 0)
            )
            when (result) {
                is Result.InProgress -> {
                    _postsUiState.update { currentState ->
                        currentState.copy(isLoading = true)
                    }
                }

                is Result.OnSuccess -> {
                    _postsUiState.update { currentState ->
                        currentState.copy(isLoading = false, data = result.data.toPostsData())
                    }
                }

                is Result.OnError -> {
                    _postsUiState.update { currentState ->
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

