package ir.divar.ui.uiState

import androidx.compose.runtime.Immutable

@Immutable
data class PostsUiState(
    val isLoading: Boolean = false,
    val data: List<PostItemUI>? = emptyList(),
    val message: String? = null
)
