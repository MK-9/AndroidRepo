package ir.divar.database.new_entity

import ir.divar.model.Centroid
import ir.divar.model.City
import ir.divar.model.newmodel.DataModel
import ir.divar.model.newmodel.PostDetailsModel
import ir.divar.model.newmodel.PostDetailsWidgetModel
import ir.divar.model.newmodel.PostModel
import ir.divar.model.newmodel.PostWidgetModel

object ExternalModelMapper {

    /**
     * Post Mapper
     */
    fun PostEntity.toPostModel() = PostModel(
        id = id, cityId = cityId, page = page, widgetList = widgetList?.map {
            it.toPostWidgetModel()
        }, lastPostDate = lastPostDate
    )

    fun PostWidgetEntity.toPostWidgetModel() = PostWidgetModel(
        id = id, widgetType = widgetType, data = data?.toDataModel(), postId = postId
    )

    private fun Data.toDataModel() = DataModel(
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
        thumbnail = thumbnail,
        items = null
    )

    /**
     * Post Details Mapper
     */

    fun PostDetailsEntity.toPostDetailsModel() = PostDetailsModel(
        id = id,
        widgets = widgets?.map { it.toPostWidgetDetailsModel() },
        enableContact = enableContact,
        contactButtonText = contactButtonText
    )

    private fun PostDetailsWidgetEntity.toPostWidgetDetailsModel() = PostDetailsWidgetModel(
        id = id, widgetType = widgetType, data = data?.toDataModel(), postDetailsId = postDetailsId
    )


    /**
     * City Mapper
     */
    fun CityEntity.toCityExternalModel() = City(
        name = name,
        id = id,
        slug = slug,
        radius = radius,
        centroid = centroid.toCentroidExternalModel()
    )

    private fun CentroidEntity.toCentroidExternalModel() = Centroid(
        latitude = latitude, longitude = longitude
    )
}