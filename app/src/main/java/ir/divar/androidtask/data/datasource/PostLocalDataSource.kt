package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.local.entity.PostEntity
import kotlinx.coroutines.flow.Flow

interface PostLocalDataSource {
    suspend fun filterPosts(cityId: Int, page: Int, lastPostDate: Int): Flow<List<PostEntity>>

    suspend fun updatePosts(post: List<PostEntity>)
}