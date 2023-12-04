package ir.divar.androidtask.data.local.entity

import ir.divar.androidtask.data.network.models.ImageItemDto
import ir.divar.androidtask.data.network.models.PostDataDto
import ir.divar.androidtask.data.network.models.PostDto

object PostEntityMapper {

    fun PostEntity.toPostDto() = PostDto(
        widgetType = widgetType,
        data = data?.toPostDataDto()
    )

    private fun PostDataEntity.toPostDataDto() = PostDataDto(
        title = title,
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
        items = null
//        items = items?.map { it.toImageItemDto() }
    )

    private fun ImageItemEntity.toImageItemDto() = ImageItemDto(
        imageUrl = imageUrl
    )

    ///////////////////////////////////
    fun PostDto.toNewPostEntity(
        page: String = "",
        lastPostDate: String = "",
    ) = PostEntity(
        page = page,
        lastPostDate = lastPostDate,
        widgetType = widgetType,
        data = data?.toPostDataEntity(),
    )

    private fun PostDataDto.toPostDataEntity() = PostDataEntity(
        title = title,
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
//        items = items?.map { it.toNewImageItemEntity() }
    )

    private fun ImageItemDto.toNewImageItemEntity() = ImageItemEntity(
        imageUrl = imageUrl
    )
}