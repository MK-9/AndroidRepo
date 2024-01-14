package ir.divar.database.new_entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val cityId: Int,
    val page: String,
    val widgetList: List<PostWidgetEntity>? = arrayListOf(),
    val lastPostDate: Long?
)
