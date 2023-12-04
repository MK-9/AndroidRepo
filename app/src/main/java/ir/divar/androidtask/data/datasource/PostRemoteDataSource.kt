package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.network.models.Result
import ir.divar.androidtask.data.network.models.request.PostListRequest
import ir.divar.androidtask.data.network.models.PostsDto
import ir.divar.androidtask.data.network.models.PostDetailsDto

interface PostRemoteDataSource {
    suspend fun getPostList(
        accessToken: String?,
        selectedCityId: Int,
        body: PostListRequest
    ): Result<PostsDto>

    suspend fun getPostView(accessToken: String?, postToken: String?): Result<PostDetailsDto>
}