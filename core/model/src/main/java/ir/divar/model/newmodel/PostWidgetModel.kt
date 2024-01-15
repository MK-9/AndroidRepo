package ir.divar.model.newmodel

data class PostWidgetModel(
    val id: Long = 0,
    val widgetType: String?,
    val data: DataModel?,
    val postId: Long = 0
)
