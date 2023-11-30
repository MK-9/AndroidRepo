package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.model.Result
import ir.divar.androidtask.data.model.request.PostListRequest
import ir.divar.androidtask.data.model.response.PostsDto
import ir.divar.androidtask.data.model.response.PostDetailsDto
import ir.divar.androidtask.data.repository.DispatcherProvider
import ir.divar.androidtask.data.service.PostService
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultPostRemoteDataSource @Inject constructor(
    private val dispatcher: DispatcherProvider,
    private val service: PostService
) : PostRemoteDataSource {

    override suspend fun getPostList(
        accessToken: String?,
        selectedCityId: Int,
        body: PostListRequest
    ): Result<PostsDto> {
        return withContext(dispatcher.io()) {
            safeApiCall {
                service.getPostList(accessToken, selectedCityId, body)
            }
        }
    }

    override suspend fun getPostView(
        accessToken: String?,
        postToken: String?
    ): Result<PostDetailsDto> {
        return withContext(dispatcher.io()) {
            safeApiCall {
                service.getPostView(accessToken, postToken)
            }
        }
    }

}