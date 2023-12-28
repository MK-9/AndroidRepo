package ir.divar.ui.uiState

import androidx.compose.runtime.Immutable

@Immutable
data class PostDetailsUiState(
    val isLoading: Boolean = false, val data: PostDetailsDataUI? = null, val message: String? = null
)
