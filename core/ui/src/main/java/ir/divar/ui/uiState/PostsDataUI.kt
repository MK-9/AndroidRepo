package ir.divar.ui.uiState

import androidx.compose.runtime.Immutable

@Immutable
data class PostsDataUI(
    val widgets: List<PostItemUI>? = emptyList()
)
