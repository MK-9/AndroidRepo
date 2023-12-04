package ir.divar.androidtask.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ImageItemEntity(
    @PrimaryKey val imageId: Long,
    @ColumnInfo("image_url") val imageUrl: String?,
    @ColumnInfo("post_id") val postId: Int
)
