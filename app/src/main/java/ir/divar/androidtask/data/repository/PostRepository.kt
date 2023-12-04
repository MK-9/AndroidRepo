package ir.divar.androidtask.data.repository

import ir.divar.androidtask.data.network.models.PostDetailsDto
import ir.divar.androidtask.data.network.models.PostsDto
import ir.divar.androidtask.data.network.models.Result
import ir.divar.androidtask.data.network.models.request.PostListRequest
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun getPostList(cityId: Int, body: PostListRequest): Flow<Result<PostsDto>>

    suspend fun syncPostList(cityId: Int, body: PostListRequest)

    suspend fun getPostView(postToken: String?): Flow<Result<PostDetailsDto>>
}