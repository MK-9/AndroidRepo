package ir.divar.androidtask.data.repository

import ir.divar.androidtask.data.datasource.PostRemoteDataSource
import ir.divar.androidtask.data.model.Result
import ir.divar.androidtask.data.model.request.PostListRequest
import ir.divar.androidtask.data.model.response.PostsDto
import ir.divar.androidtask.data.model.response.PostDetailsDto
import javax.inject.Inject

class DefaultPostRepository @Inject constructor(private val remoteDataSource: PostRemoteDataSource) :
    PostRepository {

    override suspend fun getPostList(
        accessToken: String?,
        selectedCityId: Int,
        body: PostListRequest
    ): Result<PostsDto> {
        return remoteDataSource.getPostList(accessToken, selectedCityId, body)
    }

    override suspend fun getPostView(
        accessToken: String?,
        postToken: String?
    ): Result<PostDetailsDto> {
        return remoteDataSource.getPostView(accessToken, postToken)
    }
}