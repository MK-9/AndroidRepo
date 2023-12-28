package ir.divar.ui.uiState

import androidx.compose.runtime.Immutable

@Immutable
data class PostDataItemUI(
    val title: String?,
    val subtitle: String?,
    val text: String?,
    val value: String?,
    val token: String?,
    val price: String?,
    val city: String?,
    val district: String?,
    val imageUrl: String?,
    val showThumbnail: Boolean = false,
    val thumbnail: String?,
    val items: List<ImageItemUI>?
)
