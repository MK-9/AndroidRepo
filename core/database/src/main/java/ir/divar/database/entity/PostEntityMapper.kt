package ir.divar.database.entity

import ir.divar.model.Post
import ir.divar.model.PostData
import ir.divar.model.Posts

/**
 *  ENTITY ---> EXTERNAL MODEL
 */
object PostEntityMapper {

    fun List<PostEntity>.toPostsExternalModel() = Posts(widgets = map {
        it.toPostExternalModel()
    }, lastPostDate = null)

    private fun PostEntity.toPostExternalModel() = Post(
        uuid = uuid,
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