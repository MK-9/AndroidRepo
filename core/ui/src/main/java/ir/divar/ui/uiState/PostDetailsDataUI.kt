package ir.divar.ui.uiState

import androidx.compose.runtime.Immutable

@Immutable
data class PostDetailsDataUI(
    val widgets: List<PostItemUI>?, val enableContact: Boolean = false, val contactButtonText: String?
)
