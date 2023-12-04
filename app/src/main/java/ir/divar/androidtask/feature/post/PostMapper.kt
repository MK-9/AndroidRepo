package ir.divar.androidtask.feature.post

import ir.divar.androidtask.data.network.models.ImageItemDto
import ir.divar.androidtask.data.network.models.PostDataDto
import ir.divar.androidtask.data.network.models.PostDto
import ir.divar.androidtask.data.network.models.PostDetailsDto
import ir.divar.androidtask.data.network.models.PostsDto
import ir.divar.androidtask.feature.generic.uiState.ImageItem
import ir.divar.androidtask.feature.generic.uiState.PostDataItem
import ir.divar.androidtask.feature.generic.uiState.PostDetailsData
import ir.divar.androidtask.feature.generic.uiState.PostItem
import ir.divar.androidtask.feature.generic.uiState.PostsData

object PostMapper {

    fun PostDetailsDto.toPostDetailsData() = PostDetailsData(
        widgets = widgets?.map { it.toPostItem() },
        enableContact = enableContact,
        contactButtonText = contactButtonText
    )

    fun PostsDto.toPostsData() = PostsData(
        widgets = widgets?.map { it.toPostItem() }, lastPostDate = lastPostDate
    )

    private fun PostDto.toPostItem() = PostItem(
        widgetType = widgetType, data = data?.toPostDataItem(), null
    )

    private fun PostDataDto.toPostDataItem() = PostDataItem(title = title,
        subtitle = subtitle,
        text = text,
        value = value,
        token = token,
        price = price,
        city = city,
        district = district,
        imageUrl = imageUrl,
        showThumbnail = showThumbnail,
        thumbnail = thumbnail,
        items = items?.map { it.toImageItem() })

    private fun ImageItemDto.toImageItem() = ImageItem(imageUrl = imageUrl)
}