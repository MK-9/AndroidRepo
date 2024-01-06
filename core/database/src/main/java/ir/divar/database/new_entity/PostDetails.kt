package ir.divar.database.new_entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "postDetails", foreignKeys = [ForeignKey(
        entity = Widget::class,
        parentColumns = ["id"],
        childColumns = ["widgetId"],
        onDelete = ForeignKey.CASCADE
    )]
)
internal data class PostDetails(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val widgetId: String,
    val postToken: String,
    val enableContact: Boolean,
    val contactButtonText: String
)
