package ir.divar.androidtask.data.local.entity

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ir.divar.androidtask.data.model.Post
import ir.divar.androidtask.data.model.PostData
import ir.divar.androidtask.data.network.models.ImageItemDto
import ir.divar.androidtask.data.network.models.PostDataDto
import ir.divar.androidtask.data.network.models.PostDto

object PostEntityMapper {

    fun PostEntity.toPostDto() = PostDto(
        widgetType = widgetType, data = data?.toPostDataDto()
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
        items = Gson().fromJson(items, object : TypeToken<List<ImageItemDto>>() {}.type)
    )

    ////////////// DTO ---> ENTITY //////////////
    fun PostDto.toPostEntity(
        cityId: Int = 0,
        page: String = "",
        lastPostDate: String = "",
    ) = PostEntity(
        cityId = cityId,
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
        items = Gson().toJson(items)
    )

    ////////////// ENTITY ---> EXTERNAL MODEL //////////////
    fun PostEntity.toPostExternalModel() = Post(
        cityId = cityId,
        page = page,
        lastPostDate = lastPostDate,
        widgetType = widgetType,
        data = data?.toPostDataExternalModel(),
    )

    private fun PostDataEntity.toPostDataExternalModel() = PostData(
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
}