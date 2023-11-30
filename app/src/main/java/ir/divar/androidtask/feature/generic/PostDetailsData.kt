package ir.divar.androidtask.feature.generic

import androidx.compose.runtime.Immutable

@Immutable
data class PostDetailsData(
    val widgets: List<PostItem>?, val enableContact: Boolean?, val contactButtonText: String?
)
