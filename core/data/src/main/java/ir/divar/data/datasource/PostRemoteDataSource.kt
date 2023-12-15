package ir.divar.data.datasource

import ir.divar.androidtask.data.network.models.PostDetailsDto
import ir.divar.androidtask.data.network.models.PostsDto
import ir.divar.androidtask.data.network.models.Result

interface PostRemoteDataSource {
    suspend fun getPosts(selectedCityId: Int, page: Int, lastPostDate: Long): Result<PostsDto>

    suspend fun getPostView(postToken: String?): Result<PostDetailsDto>
}