package ir.divar.androidtask.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ir.divar.androidtask.data.local.entity.PostEntity

@Dao
interface PostDao {
    @Insert
    fun insertAll(vararg post: PostEntity)

    @Insert
    fun insertPost(postEntity: PostEntity)

    @Query("SELECT* FROM postentity")
    fun getAllPosts(): List<PostEntity>
}