package ir.divar.androidtask.feature.generic.uiState

import androidx.compose.runtime.Immutable

@Immutable
data class PostsUiState(
    val isLoading: Boolean = false,
    val data: List<PostItemUI>? = emptyList(),
    val message: String? = null
)
