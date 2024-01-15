package ir.divar.model.newmodel

data class PostModel(
    val id: Long = 0,
    val cityId: Int,
    val page: String,
    val widgetList: List<PostWidgetModel>?,
    val lastPostDate: Long?
)
