package ir.divar.androidtask.feature.generic

import androidx.compose.runtime.Immutable

@Immutable
data class PostsData(
    val widgets: List<PostItem>? = emptyList(), val lastPostDate: String? = null
)
