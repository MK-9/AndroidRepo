package ir.divar.database.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostEntity(
    @PrimaryKey(autoGenerate = true) val uuid: Long = 0,
    @ColumnInfo("cityId") val cityId: Int?,
    @ColumnInfo("page") val page: String?,
    @ColumnInfo("last_post_date") val lastPostDate: Long?,
    @ColumnInfo("widget_type") val widgetType: String?,
    @Embedded val data: PostDataEntity?
)
