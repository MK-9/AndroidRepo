package ir.divar.data.repository

import ir.divar.model.Posts
import ir.divar.network.models.PostDetailsDto
import kotlinx.coroutines.flow.Flow
import ir.divar.common.Result

interface PostRepository {
    suspend fun filterPosts(cityId: Int): Flow<Result<Posts>>

    suspend fun syncPosts(cityId: Int, page: Int, lastPostDate: Long): Flow<Result<Posts>>

    suspend fun getPostView(postToken: String?): Flow<Result<PostDetailsDto>>
}