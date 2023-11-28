package ir.divar.androidtask.data.repository

import ir.divar.androidtask.data.model.Result
import ir.divar.androidtask.data.model.request.PostListRequest
import ir.divar.androidtask.data.model.response.PostListDto
import ir.divar.androidtask.data.model.response.PostViewDto

interface PostRepository {

    suspend fun getPostList(
        accessToken: String?,
        selectedCityId: Int,
        body: PostListRequest
    ): Result<PostListDto>

    suspend fun getPostView(accessToken: String?, postToken: String?): Result<PostViewDto>

}