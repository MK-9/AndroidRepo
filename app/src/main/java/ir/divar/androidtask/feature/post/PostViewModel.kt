package ir.divar.androidtask.feature.post

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.divar.androidtask.data.model.Result
import ir.divar.androidtask.data.model.request.PostListRequest
import ir.divar.androidtask.data.repository.PostRepository
import ir.divar.androidtask.feature.post.WidgetMapper.toWidgetsData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(val repository: PostRepository) : ViewModel() {

    private var _widgetScreenUiState = MutableStateFlow(WidgetsUiState())
    val widgetScreenUiState = _widgetScreenUiState.asStateFlow()

    init {
        launchPosts(3)
    }

    private fun launchPosts(cityId: Int) {
        viewModelScope.launch {
            val result = repository.getPostList(
                accessToken = ACCESS_TOKEN, selectedCityId = cityId, body = PostListRequest(0, 0)
            )
            when (result) {
                is Result.InProgress -> {
                    _widgetScreenUiState.update { currentState ->
                        currentState.copy(isLoading = true)
                    }
                }

                is Result.OnSuccess -> {
                    _widgetScreenUiState.update { currentState ->
                        currentState.copy(isLoading = false, data = result.data.toWidgetsData())
                    }
                }

                is Result.OnError -> {
                    _widgetScreenUiState.update { currentState ->
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

@Immutable
data class WidgetsUiState(
    val isLoading: Boolean = false, val data: WidgetsData? = null, val message: String? = null
)

@Immutable
data class WidgetsData(
    val widgets: List<WidgetItem>? = emptyList(), val lastPostDate: String? = null
)

@Immutable
data class WidgetItem(
    val widgetType: String?, val data: WidgetDataItem?, val onItemClicked: (() -> Unit)?
) {
    enum class WidgetType(value: String) {
        TITLE_ROW("TITLE_ROW"), SUBTITLE_ROW("SUBTITLE_ROW"), HEADER_ROW("HEADER_ROW"), POST_ROW("POST_ROW")
    }
}

@Immutable
data class WidgetDataItem(
    val title: String?,
    val subtitle: String?,
    val text: String?,
    val value: String?,
    val token: String?,
    val price: String?,
    val city: String?,
    val district: String?,
    val imageUrl: String?,
    val showThumbnail: Boolean?,
    val thumbnail: String?,
    val items: List<ImageItem>?,
)

@Immutable
data class ImageItem(val imageUrl: String)

