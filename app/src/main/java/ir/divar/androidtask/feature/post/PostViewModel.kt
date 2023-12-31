package ir.divar.androidtask.feature.post

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.divar.androidtask.data.network.models.Result
import ir.divar.androidtask.data.network.models.request.PostListRequest
import ir.divar.androidtask.data.repository.PostRepository
import ir.divar.androidtask.feature.generic.uiState.PostsUiState
import ir.divar.androidtask.feature.post.PostMapper.toPostsData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle, private val repository: PostRepository
) : ViewModel() {

    private val cityId = checkNotNull(savedStateHandle.get<Int>("cityId"))

    private var _postsUiState = MutableStateFlow(PostsUiState())
    val postsUiState = _postsUiState.asStateFlow()

    private var lastPostDate: String? = null

    init {
        launchPosts(cityId)

        syncPostList()
    }

    private fun syncPostList() {
        viewModelScope.launch {
            repository.syncPostList(cityId = cityId, body = PostListRequest(0, 0))
        }
    }

    private fun launchPosts(cityId: Int) {
        viewModelScope.launch {

            repository.filterPosts(
                cityId = cityId, body = PostListRequest(0, lastPostDate?.toInt() ?: 0)
            ).collect { result ->

                when (result) {
                    is Result.InProgress -> {
                        _postsUiState.update { currentState ->
                            currentState.copy(isLoading = true)
                        }
                    }

                    is Result.OnSuccess -> {
                        _postsUiState.update { currentState ->
                            lastPostDate = result.data.lastPostDate
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
    }

}

