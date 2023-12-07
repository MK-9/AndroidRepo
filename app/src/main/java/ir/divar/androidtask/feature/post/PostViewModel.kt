package ir.divar.androidtask.feature.post

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.divar.androidtask.data.model.Posts
import ir.divar.androidtask.data.network.models.Result
import ir.divar.androidtask.data.network.models.request.PostListRequest
import ir.divar.androidtask.data.repository.PostRepository
import ir.divar.androidtask.feature.generic.uiState.PostItemUI
import ir.divar.androidtask.feature.generic.uiState.PostsUiState
import ir.divar.androidtask.feature.post.PostUIMapper.toPostsItemUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class PlaceHolderState {
    data class Idle(val isEmpty: Boolean) : PlaceHolderState()
    data object Loading : PlaceHolderState()
    data class Failure(val throwable: Throwable) : PlaceHolderState()
}

@HiltViewModel
class PostViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle, private val repository: PostRepository
) : ViewModel() {

    private val cityId = checkNotNull(savedStateHandle.get<Int>("cityId"))

    private var _postsUiState = MutableStateFlow(PostsUiState())
    val postsUiState = _postsUiState.asStateFlow()

    private var _loadingStateFlow = MutableStateFlow<PlaceHolderState>(PlaceHolderState.Idle(true))
    val loadingStateFlow = _loadingStateFlow.asStateFlow()

    private var lastPostDate: String? = null
    private var lastPage: Int = 0

    init {
        loadPageInternal()

        syncPostList()
    }

    fun loadNextPage() {
        lastPage++

        Log.d("######", "lastPage: $lastPage")
//        Log.d("######", "_loadingStateFlow: loading")

        syncPostList()
    }

    private fun loadPageInternal() {
        viewModelScope.launch {
            repository.filterPosts(
                cityId = cityId, body = PostListRequest(lastPage, lastPostDate?.toInt() ?: 0)
            ).collect { result ->

                when (result) {
                    is Result.InProgress -> {
//                        _postsUiState.update { currentState ->
//                            currentState.copy(isLoading = true)
//                        }
                    }

                    is Result.OnSuccess -> {
                        Log.d("######", "result: OnSuccess")

//                        _loadingStateFlow.value = PlaceHolderState.Idle(false)
                        val currentList: List<PostItemUI>? = _postsUiState.value.data
                        Log.d("######", "currentList: ${currentList?.size}")


                        val posts: Posts = result.data
                        val newList: List<PostItemUI>? = posts.toPostsItemUI()

                        val output = ArrayList<PostItemUI>()
                        if (currentList != null) {
                            output.addAll(currentList)
                            Log.d("######", "output 1: ${output.size}")
                        }

                        if (newList != null) {
                            output.addAll(newList)
                            Log.d("######", "output 2: ${output.size}")
                        }


                        _postsUiState.update { currentState ->
                            currentState.copy(isLoading = false, data = output)
                        }

                        _loadingStateFlow.value = PlaceHolderState.Idle(false)
                    }

                    is Result.OnError -> {
//                        _postsUiState.update { currentState ->
//                            currentState.copy(isLoading = false)
//                        }
                    }
                }
            }
        }
    }

    private fun syncPostList() {
        viewModelScope.launch {
            _loadingStateFlow.value = PlaceHolderState.Loading

            repository.syncPostList(
                cityId = cityId,
                body = PostListRequest(lastPage, lastPostDate?.toInt() ?: 0)
            ).collectLatest {
                when (it) {
                    is Result.OnSuccess -> {
//                        _loadingStateFlow.value = PlaceHolderState.Idle(false)
                    }

                    else -> {
                    }
                }
            }
        }
    }
}

