package ir.divar.database.new_entity

data class Data(
    val token: String?,
    val title: String?,
    val subtitle: String?,
    val text: String?,
    val value: String?,
    val price: String?,
    val city: String?,
    val district: String?,
    val imageUrl: String?,
    val showThumbnail: Boolean,
    val thumbnail: String?,
//    @ColumnInfo("imageItems") val items: String?
)