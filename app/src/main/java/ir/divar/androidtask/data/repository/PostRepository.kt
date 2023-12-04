package ir.divar.androidtask.data.repository

import ir.divar.androidtask.data.network.models.PostDetailsDto
import ir.divar.androidtask.data.network.models.PostsDto
import ir.divar.androidtask.data.network.models.Result
import ir.divar.androidtask.data.network.models.request.PostListRequest
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun getPostList(selectedCityId: Int, body: PostListRequest): Flow<Result<PostsDto>>

    suspend fun getPostView(postToken: String?): Flow<Result<PostDetailsDto>>
}