package ir.divar.androidtask.feature.generic.uiState

import androidx.compose.runtime.Immutable

@Immutable
data class PostDetailsDataUI(
    val widgets: List<PostItemUI>?, val enableContact: Boolean = false, val contactButtonText: String?
)
