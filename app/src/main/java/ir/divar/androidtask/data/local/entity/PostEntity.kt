package ir.divar.androidtask.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostEntity(
    @PrimaryKey(autoGenerate = true) val uuid: Long = 0,
    @ColumnInfo("page") val page: String?,
    @ColumnInfo("last_post_date") val lastPostDate: String?,


    @ColumnInfo("widget_type") val widgetType: String?,
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
)