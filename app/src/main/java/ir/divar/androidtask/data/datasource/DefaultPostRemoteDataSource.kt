package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.model.Result
import ir.divar.androidtask.data.model.request.PostListRequest
import ir.divar.androidtask.data.model.response.PostListDto
import ir.divar.androidtask.data.model.response.PostViewDto
import ir.divar.androidtask.data.repository.DispatcherProvider
import ir.divar.androidtask.data.service.PostService
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultPostRemoteDataSource @Inject constructor(
    val dispatcher: DispatcherProvider,
    val service: PostService
) : PostRemoteDataSource {

    override suspend fun getPostList(
        accessToken: String?,
        selectedCityId: Int,
        body: PostListRequest
    ): Result<PostListDto> {
        return withContext(dispatcher.io()) {
            safeApiCall {
                service.getPostList(accessToken, selectedCityId, body)
            }
        }
    }

    override suspend fun getPostView(
        accessToken: String?,
        postToken: String?
    ): Result<PostViewDto> {
        return withContext(dispatcher.io()) {
            safeApiCall {
                service.getPostView(accessToken, postToken)
            }
        }
    }

}