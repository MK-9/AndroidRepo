package ir.divar.database.new_entity

import ir.divar.model.newmodel.CentroidModel
import ir.divar.model.newmodel.CityModel
import ir.divar.model.newmodel.DataModel
import ir.divar.model.newmodel.PostDetailsModel
import ir.divar.model.newmodel.PostDetailsWidgetModel
import ir.divar.model.newmodel.PostModel
import ir.divar.model.newmodel.PostWidgetModel

object ExternalModelMapper {

    /**
     * Post Mapper
     */
    fun PostEntity.toPostExternalModel() = PostModel(
        id = id, cityId = cityId, page = page, widgetList = widgetList?.map {
            it.toPostWidgetExternalModel()
        }, lastPostDate = lastPostDate
    )

    fun PostWidgetEntity.toPostWidgetExternalModel() = PostWidgetModel(
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
    fun PostDetailsEntity.toPostDetailsExternalModel() = PostDetailsModel(
        id = id,
        widgets = widgets?.map { it.toPostDetailsWidgetModel() },
        enableContact = enableContact,
        contactButtonText = contactButtonText
    )

    private fun PostDetailsWidgetEntity.toPostDetailsWidgetModel() = PostDetailsWidgetModel(
        id = id, widgetType = widgetType, data = data?.toDataModel(), postDetailsId = postDetailsId
    )


    /**
     * City Mapper
     */
    fun CityEntity.toCityExternalModel() = CityModel(
        name = name,
        id = id,
        slug = slug,
        radius = radius,
        centroid = centroid?.toCentroidExternalModel()
    )

    private fun CentroidEntity.toCentroidExternalModel() = CentroidModel(
        latitude = latitude, longitude = longitude
    )
}