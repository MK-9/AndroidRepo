package ir.divar.data.repository.mapper

import ir.divar.database.new_entity.CentroidEntity
import ir.divar.database.new_entity.CityEntity
import ir.divar.database.new_entity.Data
import ir.divar.database.new_entity.PostDetailsEntity
import ir.divar.database.new_entity.PostDetailsWidgetEntity
import ir.divar.database.new_entity.PostEntity
import ir.divar.database.new_entity.PostWidgetEntity
import ir.divar.network.models.CentroidDto
import ir.divar.network.models.CityDto
import ir.divar.network.models.PostDataDto
import ir.divar.network.models.PostDetailsDto
import ir.divar.network.models.PostDto
import ir.divar.network.models.PostsDto

/**
 *  Network ---> Entity
 */
object NetworkMapper {

    fun CityDto.toCityEntity() = CityEntity(
        name = name, id = id, slug = slug, radius = radius, centroid = centroid?.toCentroidEntity()
    )

    private fun CentroidDto.toCentroidEntity() = CentroidEntity(
        latitude = latitude, longitude = longitude
    )

    fun PostsDto.toPosts(cityId: Int, page: String) = PostEntity(
        page = page, cityId = cityId, widgetList = widgetList?.map {
            it.toPostWidget()
        }, lastPostDate = lastPostDate
    )

    fun PostDetailsDto.toPostDetails() = PostDetailsEntity(widgets = widgets?.map {
        it.toPostDetailsWidget()
    }, enableContact = enableContact, contactButtonText = contactButtonText)


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

    private fun PostDto.toPostWidget() = PostWidgetEntity(widgetType = widgetType, data = data?.toData())

    private fun PostDto.toPostDetailsWidget() =
        PostDetailsWidgetEntity(widgetType = widgetType, data = data?.toData())


    //old style
//    fun PostsDto.toPostEntity(cityId: Int = 0, page: String? = ""): List<PostEntity>? {
//        return widgetList?.map {
//            PostEntity(
//                cityId = cityId,
//                page = page,
//                lastPostDate = lastPostDate,
//                widgetType = it.widgetType,
//                data = it.data?.toPostDataEntity(),
//            )
//        }
//    }
//
//    private fun PostDataDto.toPostDataEntity() = PostDataEntity(
//        title = title,
//        subtitle = subtitle,
//        text = text,
//        value = value,
//        token = token,
//        price = price,
//        city = city,
//        district = district,
//        imageUrl = imageUrl,
//        showThumbnail = showThumbnail,
//        thumbnail = thumbnail,
//        items = Gson().toJson(items)
//    )
}