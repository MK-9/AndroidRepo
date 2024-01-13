package ir.divar.database.new_entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "post", foreignKeys = [ForeignKey(
        entity = City::class,
        parentColumns = ["id"],
        childColumns = ["cityId"],
        onDelete = ForeignKey.NO_ACTION
    )]
)
data class Post(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val cityId: Int,
    val page: String,
    val widgetList: List<PostWidget>?,
    val lastPostDate: Long?
)
