package ir.divar.androidtask.data.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ir.divar.androidtask.data.model.entity.PostEntity

@Dao
interface PostDao {
    @Insert
    fun insertAll(vararg post: PostEntity)

    @Insert
    fun insertPost(postEntity: PostEntity)

    @Query("SELECT* FROM postentity")
    fun getAllPosts(): List<PostEntity>
}