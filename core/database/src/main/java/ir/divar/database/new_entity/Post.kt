package ir.divar.database.new_entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "posts", foreignKeys = [ForeignKey(
        entity = City::class,
        parentColumns = ["id"],
        childColumns = ["cityId"],
        onDelete = ForeignKey.NO_ACTION
    ), ForeignKey(
        entity = Widget::class,
        parentColumns = ["id"],
        childColumns = ["widgetId"],
        onDelete = ForeignKey.CASCADE
    )]
)
internal data class Post(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val cityId: Int,
    val widgetId: String,
    val page: String,
    val lastPostDate: String
)
