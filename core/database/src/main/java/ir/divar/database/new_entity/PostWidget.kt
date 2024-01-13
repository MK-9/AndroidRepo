package ir.divar.database.new_entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "postWidget", indices = [Index(name = "postId")], foreignKeys = [ForeignKey(
        entity = Post::class,
        parentColumns = ["id"],
        childColumns = ["postId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class PostWidget(
    @PrimaryKey val id: Long = 0,
    val widgetType: String?,
    @Embedded val data: Data?,
    val postId: Int = 0
)
