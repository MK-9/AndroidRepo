package ir.divar.model

data class Post(
    val uuid: Long?,
    val cityId: Int?,
    val page: String?,
    val lastPostDate: Long?,
    val widgetType: String?,
    val data: PostData?
)
