package ir.divar.database.new_entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "postDetailsWidget", foreignKeys = [ForeignKey(
        entity = PostDetailsEntity::class,
        parentColumns = ["id"],
        childColumns = ["postDetailsId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class PostDetailsWidgetEntity(
    @PrimaryKey val id: Long = 0,
    val widgetType: String?,
    @Embedded val data: Data?,
    val postDetailsId: Long = 0
)
