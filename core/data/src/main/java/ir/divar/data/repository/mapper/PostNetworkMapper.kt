package ir.divar.data.repository.mapper

import com.google.gson.Gson
import ir.divar.database.entity.PostDataEntity
import ir.divar.database.entity.PostEntity
import ir.divar.network.models.PostDataDto
import ir.divar.network.models.PostsDto

/**
 *  Network ---> Entity
 */
object PostNetworkMapper {

    fun PostsDto.toPostEntity(cityId: Int = 0, page: String? = ""): List<PostEntity>? {
        return widgets?.map {
            PostEntity(
                cityId = cityId,
                page = page,
                lastPostDate = lastPostDate,
                widgetType = it.widgetType,
                data = it.data?.toPostDataEntity(),
            )
        }
    }

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
}