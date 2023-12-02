package ir.divar.androidtask.feature.generic.uiState

import androidx.compose.runtime.Immutable

@Immutable
data class PostsData(
    val widgets: List<PostItem>? = emptyList(), val lastPostDate: String? = null
)
