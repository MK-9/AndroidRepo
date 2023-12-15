package ir.divar.data.datasource

import ir.divar.database.entity.PostEntity
import kotlinx.coroutines.flow.Flow

interface PostLocalDataSource {
    suspend fun filterPosts(cityId: Int): Flow<List<PostEntity>>

    suspend fun updatePosts(post: List<PostEntity>)
}