package ir.divar.androidtask.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ir.divar.androidtask.data.local.entity.PostEntity

@Dao
interface PostDao {
    @Insert
    fun insertPost(post: PostEntity)

    @Query("SELECT* FROM PostEntity")
    fun getAllPosts():List<PostEntity>
}