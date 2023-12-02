package ir.divar.androidtask.feature.generic.uiState

import androidx.compose.runtime.Immutable

@Immutable
data class PostDetailsData(
    val widgets: List<PostItem>?, val enableContact: Boolean = false, val contactButtonText: String?
)
