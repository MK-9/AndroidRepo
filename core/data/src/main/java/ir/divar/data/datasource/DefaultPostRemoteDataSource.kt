package ir.divar.data.datasource

import ir.divar.androidtask.data.network.models.PostDetailsDto
import ir.divar.androidtask.data.network.models.PostsDto
import ir.divar.androidtask.data.network.models.Result
import ir.divar.androidtask.data.network.models.request.PostListRequest
import ir.divar.androidtask.data.network.service.PostService
import ir.divar.data.repository.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultPostRemoteDataSource @Inject constructor(
    private val dispatcher: DispatcherProvider,
    private val service: PostService
) : PostRemoteDataSource {

    override suspend fun getPosts(
        selectedCityId: Int,
        page: Int,
        lastPostDate: Long
    ): Result<PostsDto> {
        return withContext(dispatcher.io()) {
            safeApiCall {
                service.getPostList(
                    selectedCityId,
                    PostListRequest(page = page, last_post_date = lastPostDate)
                )
            }
        }
    }

    override suspend fun getPostView(
        postToken: String?
    ): Result<PostDetailsDto> {
        return withContext(dispatcher.io()) {
            safeApiCall {
                service.getPostView(postToken)
            }
        }
    }

}