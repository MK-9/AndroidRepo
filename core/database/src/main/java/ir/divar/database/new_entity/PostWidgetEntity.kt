package ir.divar.database.new_entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "postWidget", indices = [Index(name = "postId")], foreignKeys = [ForeignKey(
        entity = PostEntity::class,
        parentColumns = ["id"],
        childColumns = ["postId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class PostWidgetEntity(
    @PrimaryKey val id: Long = 0,
    val widgetType: String?,
    @Embedded val data: Data?,
    var postId: Long = 0
)
