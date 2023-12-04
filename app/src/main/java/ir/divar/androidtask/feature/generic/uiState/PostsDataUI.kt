package ir.divar.androidtask.feature.generic.uiState

import androidx.compose.runtime.Immutable

@Immutable
data class PostsDataUI(
    val widgets: List<PostItemUI>? = emptyList(), val lastPostDate: String? = null
)
