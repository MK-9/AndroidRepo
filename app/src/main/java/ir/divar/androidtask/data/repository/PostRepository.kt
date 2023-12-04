package ir.divar.androidtask.data.repository

import ir.divar.androidtask.data.network.models.Result
import ir.divar.androidtask.data.network.models.request.PostListRequest
import ir.divar.androidtask.data.network.models.PostDetailsDto
import ir.divar.androidtask.data.network.models.PostsDto
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    suspend fun getPostList(
        accessToken: String?, selectedCityId: Int, body: PostListRequest
    ): Flow<Result<PostsDto>>

    suspend fun getPostView(accessToken: String?, postToken: String?): Flow<Result<PostDetailsDto>>

}