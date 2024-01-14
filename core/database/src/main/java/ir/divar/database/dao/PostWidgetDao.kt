package ir.divar.database.dao

import androidx.room.Insert
import ir.divar.database.new_entity.PostWidgetEntity

interface PostWidgetDao {

    @Insert
    fun insertPostWidgets(postWidget: List<PostWidgetEntity>?)
}