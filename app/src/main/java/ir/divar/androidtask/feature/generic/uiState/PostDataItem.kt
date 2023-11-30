package ir.divar.androidtask.feature.generic.uiState

import androidx.compose.runtime.Immutable

@Immutable
data class PostDataItem(
    val title: String?,
    val subtitle: String?,
    val text: String?,
    val value: String?,
    val token: String?,
    val price: String?,
    val city: String?,
    val district: String?,
    val imageUrl: String?,
    val showThumbnail: Boolean?,
    val thumbnail: String?,
    val items: List<ImageItem>?
)

@Immutable
data class ImageItem(val imageUrl: String)