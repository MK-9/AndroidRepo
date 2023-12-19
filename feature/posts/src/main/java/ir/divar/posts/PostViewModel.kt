package ir.divar.posts

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.divar.androidtask.data.model.Posts
import ir.divar.androidtask.feature.generic.uiState.PostItemUI
import ir.divar.androidtask.feature.generic.uiState.PostsUiState
import ir.divar.posts.PostUIMapper.toPostsItemUI
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
    savedStateHandle: SavedStateHandle, private val repository: ir.divar.data.repository.PostRepository
) : ViewModel() {

    private val cityId = checkNotNull(savedStateHandle.get<Int>("cityId"))

    private var _postsUiState = MutableStateFlow(PostsUiState())
    val postsUiState = _postsUiState.asStateFlow()

    private var _loadingStateFlow = MutableStateFlow<PlaceHolderState>(PlaceHolderState.Idle(true))
    val loadingStateFlow = _loadingStateFlow.asStateFlow()

    private var lastPostDate by mutableLongStateOf(0)
    private var lastPage by mutableIntStateOf(0)

    init {
        loadPageInternal()

        syncPosts()
    }

    fun loadNextPage() {
        lastPage++

        Log.d("######", "lastPage: $lastPage")
        Log.d("######", "lastPostDate: $lastPostDate")

        syncPosts()
    }

    private fun loadPageInternal() {
        viewModelScope.launch {
            repository.filterPosts(cityId = cityId).collect { result ->

                when (result) {
                    is Result.InProgress -> {
//                        _postsUiState.update { currentState ->
//                            currentState.copy(isLoading = true)
//                        }
                    }

                    is Result.OnSuccess -> {
                        val posts: Posts = result.data
                        var newList: List<PostItemUI>? = posts.toPostsItemUI()

                        if (newList.isNullOrEmpty()) return@collect

                        newList =
                            newList.filter { post -> post.page == lastPage.toString() }

                        lastPostDate = newList[0].lastPostDate!!

                        val currentList: List<PostItemUI>? = _postsUiState.value.data

                        val output = ArrayList<PostItemUI>()

                        if (currentList != null) {
                            output.addAll(currentList)
                        }
                        output.addAll(newList)


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

    private fun syncPosts() {
        viewModelScope.launch {
            _loadingStateFlow.value = PlaceHolderState.Loading

            repository.syncPosts(
                cityId = cityId, page = lastPage, lastPostDate = lastPostDate
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

