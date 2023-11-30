package ir.divar.androidtask.feature.generic

import androidx.compose.runtime.Immutable

@Immutable
data class PostDetailsUiState(
    val isLoading: Boolean = false, val data: PostDetailsData? = null, val message: String? = null
)
