package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.network.models.PostDetailsDto
import ir.divar.androidtask.data.network.models.PostsDto
import ir.divar.androidtask.data.network.models.Result
import ir.divar.androidtask.data.network.models.request.PostListRequest

interface PostRemoteDataSource {
    suspend fun getPostList(selectedCityId: Int, body: PostListRequest): Result<PostsDto>

    suspend fun getPostView(postToken: String?): Result<PostDetailsDto>
}