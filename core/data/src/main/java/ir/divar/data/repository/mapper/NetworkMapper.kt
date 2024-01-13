package ir.divar.data.repository.mapper

import com.google.gson.Gson
import ir.divar.database.entity.PostDataEntity
import ir.divar.database.entity.PostEntity
import ir.divar.database.new_entity.Data
import ir.divar.database.new_entity.Post
import ir.divar.database.new_entity.PostDetails
import ir.divar.database.new_entity.PostDetailsWidget
import ir.divar.database.new_entity.PostWidget
import ir.divar.network.models.PostDataDto
import ir.divar.network.models.PostDetailsDto
import ir.divar.network.models.PostDto
import ir.divar.network.models.PostsDto

/**
 *  Network ---> Entity
 */
object NetworkMapper {

    fun PostsDto.toPosts(cityId: Int, page: String) = Post(
        page = page, cityId = cityId, widgetList = widgets?.map {
            it.toPostWidget()
        }, lastPostDate = lastPostDate
    )

    private fun PostDto.toPostWidget() = PostWidget(widgetType = widgetType, data = data?.toData())

    private fun PostDataDto.toData() = Data(
        token = token,
        title = title,
        subtitle = subtitle,
        text = text,
        value = value,
        price = price,
        city = city,
        district = district,
        imageUrl = imageUrl,
        showThumbnail = showThumbnail,
        thumbnail = thumbnail
    )

    fun PostDetailsDto.toPostDetails() = PostDetails(widgets = widgets?.map {
        it.toPostDetailsWidget()
    }, enableContact = enableContact, contactButtonText = contactButtonText)

    private fun PostDto.toPostDetailsWidget() = PostDetailsWidget(
        widgetType = widgetType, data = data?.toData()
    )

    //old style
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