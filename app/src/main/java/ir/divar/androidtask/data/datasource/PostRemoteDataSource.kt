package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.model.Result
import ir.divar.androidtask.data.model.request.PostListRequest
import ir.divar.androidtask.data.model.response.PostListDto
import ir.divar.androidtask.data.model.response.PostViewDto

interface PostRemoteDataSource {
    suspend fun getPostList(
        accessToken: String?,
        selectedCityId: Int,
        body: PostListRequest
    ): Result<PostListDto>

    suspend fun getPostView(accessToken: String?, postToken: String?): Result<PostViewDto>
}