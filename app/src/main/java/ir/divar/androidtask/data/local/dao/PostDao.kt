package ir.divar.androidtask.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import ir.divar.androidtask.data.local.entity.PostEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Insert
    fun insertPosts(posts: List<PostEntity>)

    @Transaction
    fun updatePosts(posts: List<PostEntity>) {
        deletePosts()
        insertPosts(posts)
    }

    @Query("DELETE FROM PostEntity")
    fun deletePosts()

    @Query("SELECT* FROM PostEntity")
    fun getAllPosts(): Flow<List<PostEntity>>
}