package ir.divar.androidtask.data.local.entity

import androidx.room.ColumnInfo

data class PostDataEntity(
    @ColumnInfo("title") val title: String?,
    @ColumnInfo("subtitle") val subtitle: String?,
    @ColumnInfo("text") val text: String?,
    @ColumnInfo("value") val value: String?,
    @ColumnInfo("token") val token: String?,
    @ColumnInfo("price") val price: String?,
    @ColumnInfo("city") val city: String?,
    @ColumnInfo("district") val district: String?,
    @ColumnInfo("image_url") val imageUrl: String?,
    @ColumnInfo("show_thumbnail") val showThumbnail: Boolean,
    @ColumnInfo("thumbnail") val thumbnail: String?,

//    @Embedded val items: List<NewImageItemEntity>?
)
