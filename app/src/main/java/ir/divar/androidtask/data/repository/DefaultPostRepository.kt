package ir.divar.androidtask.data.repository

import ir.divar.androidtask.data.datasource.PostRemoteDataSource
import ir.divar.androidtask.data.model.Result
import ir.divar.androidtask.data.model.request.PostListRequest
import ir.divar.androidtask.data.model.response.PostListDto
import ir.divar.androidtask.data.model.response.PostViewDto
import javax.inject.Inject

class DefaultPostRepository @Inject constructor(val remoteDataSource: PostRemoteDataSource) :
    PostRepository {

    override suspend fun getPostList(
        accessToken: String?,
        selectedCityId: Int,
        body: PostListRequest
    ): Result<PostListDto> {
        return remoteDataSource.getPostList(accessToken, selectedCityId, body)
    }

    override suspend fun getPostView(
        accessToken: String?,
        postToken: String?
    ): Result<PostViewDto> {
        return remoteDataSource.getPostView(accessToken, postToken)
    }
}