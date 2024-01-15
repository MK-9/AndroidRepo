package ir.divar.database.new_entity

import ir.divar.model.newmodel.DataModel
import ir.divar.model.newmodel.PostDetailsWidgetModel
import ir.divar.model.newmodel.PostModel
import ir.divar.model.newmodel.PostWidgetModel

object ExternalModelMapper {

    fun PostEntity.toPostModel() = PostModel(
        id = id, cityId = cityId, page = page, widgetList = widgetList?.map {
            it.toPostWidgetModel()
        }, lastPostDate = lastPostDate
    )

    fun PostWidgetEntity.toPostWidgetModel() = PostWidgetModel(
        id = id, widgetType = widgetType, data = data?.toDataModel(), postId = postId
    )


    fun PostDetailsWidgetEntity.toPostWidgetDetailsModel() = PostDetailsWidgetModel(
        id = id,
        widgetType = widgetType,
        data = data?.toDataModel(),
        postDetailsId = postDetailsId
    )

    fun Data.toDataModel() = DataModel(
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
}