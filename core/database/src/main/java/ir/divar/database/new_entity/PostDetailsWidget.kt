package ir.divar.database.new_entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "postDetailsWidget", foreignKeys = [ForeignKey(
        entity = PostDetails::class,
        parentColumns = ["id"],
        childColumns = ["postDetailsId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class PostDetailsWidget(
    @PrimaryKey val id: Long = 0,
    val widgetType: String?,
    @Embedded val data: Data?,
    val postDetailsId: Int = 0
)
