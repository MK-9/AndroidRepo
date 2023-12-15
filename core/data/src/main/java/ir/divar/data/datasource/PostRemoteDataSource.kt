package ir.divar.data.datasource

import ir.divar.network.models.PostDetailsDto
import ir.divar.network.models.PostsDto
import ir.divar.common.Result

interface PostRemoteDataSource {
    suspend fun getPosts(selectedCityId: Int, page: Int, lastPostDate: Long): Result<PostsDto>

    suspend fun getPostView(postToken: String?): Result<PostDetailsDto>
}