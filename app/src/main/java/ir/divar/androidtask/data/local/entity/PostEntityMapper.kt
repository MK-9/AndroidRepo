package ir.divar.androidtask.data.local.entity

import ir.divar.androidtask.data.network.models.PostDataDto
import ir.divar.androidtask.data.network.models.PostDto

object PostEntityMapper {


    fun PostEntity.toPostDto() = PostDto(
        widgetType = widgetType,
        data = PostDataDto(
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
        )
    )

    fun PostDto.toPostEntity(
        lastPostDate: String = "",
        page: String = ""
    ) = PostEntity(
        lastPostDate = "",
        page = "",
        widgetType = widgetType,
        title = data?.title,
        subtitle = data?.subtitle,
        text = data?.text,
        value = data?.value,
        token = data?.token,
        price = data?.price,
        city = data?.city,
        district = data?.district,
        imageUrl = data?.imageUrl,
        showThumbnail = data?.showThumbnail ?: false,
        thumbnail = data?.thumbnail,
    )

}