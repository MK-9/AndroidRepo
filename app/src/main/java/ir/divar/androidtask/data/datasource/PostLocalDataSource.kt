package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.local.entity.PostEntity
 import kotlinx.coroutines.flow.Flow

interface PostLocalDataSource {
    suspend fun getPostList(): Flow<List<PostEntity>>

    suspend fun updatePosts(post: List<PostEntity>)
}