package ir.divar.androidtask.data.repository

import ir.divar.androidtask.data.model.Posts
import ir.divar.androidtask.data.network.models.PostDetailsDto
import ir.divar.androidtask.data.network.models.Result
import ir.divar.androidtask.data.network.models.request.PostListRequest
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun filterPosts(cityId: Int, body: PostListRequest): Flow<Result<Posts>>

    suspend fun syncPostList(cityId: Int, body: PostListRequest)

    suspend fun getPostView(postToken: String?): Flow<Result<PostDetailsDto>>
}