package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.model.Result
import ir.divar.androidtask.data.model.request.PostListRequest
import ir.divar.androidtask.data.model.response.PostsDto
import ir.divar.androidtask.data.model.response.PostDetailsDto

interface PostRemoteDataSource {
    suspend fun getPostList(
        accessToken: String?,
        selectedCityId: Int,
        body: PostListRequest
    ): Result<PostsDto>

    suspend fun getPostView(accessToken: String?, postToken: String?): Result<PostDetailsDto>
}