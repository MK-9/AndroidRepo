package ir.divar.androidtask.feature.generic

import androidx.compose.runtime.Immutable

@Immutable
data class PostsUiState(
    val isLoading: Boolean = false, val data: PostsData? = null, val message: String? = null
)
