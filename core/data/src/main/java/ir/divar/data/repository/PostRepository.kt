package ir.divar.data.repository

import ir.divar.androidtask.data.model.Posts
import ir.divar.androidtask.data.network.models.PostDetailsDto
import ir.divar.androidtask.data.network.models.Result
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun filterPosts(cityId: Int): Flow<Result<Posts>>

    suspend fun syncPosts(cityId: Int, page: Int, lastPostDate: Long): Flow<Result<Posts>>

    suspend fun getPostView(postToken: String?): Flow<Result<PostDetailsDto>>
}