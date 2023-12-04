package ir.divar.androidtask.data.repository

import ir.divar.androidtask.data.datasource.PostLocalDataSource
import ir.divar.androidtask.data.datasource.PostRemoteDataSource
import ir.divar.androidtask.data.local.entity.PostEntityMapper.toPostDto
import ir.divar.androidtask.data.local.entity.PostEntityMapper.toPostEntity
import ir.divar.androidtask.data.network.models.PostDetailsDto
import ir.divar.androidtask.data.network.models.PostsDto
import ir.divar.androidtask.data.network.models.Result
import ir.divar.androidtask.data.network.models.request.PostListRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultPostRepository @Inject constructor(
    private val remoteDataSource: PostRemoteDataSource,
    private val localDataSource: PostLocalDataSource
) : PostRepository {

    override suspend fun filterPosts(
        cityId: Int, body: PostListRequest
    ): Flow<Result<PostsDto>> {
        return localDataSource.filterPosts(cityId, body.page, body.last_post_date).map { post ->
            val postsDto = PostsDto(widgets = post.map { it.toPostDto() }, lastPostDate = null)
            Result.OnSuccess(postsDto)
        }
    }

    override suspend fun syncPostList(cityId: Int, body: PostListRequest) {
        when (val result = remoteDataSource.getPostList(cityId, body)) {
            is Result.OnSuccess -> {
                result.data.widgets?.run {
                    localDataSource.updatePosts(map {
                        it.toPostEntity(
                            cityId = cityId,
                            page = body.page.toString(),
                            lastPostDate = body.last_post_date.toString()
                        )
                    })
                }
            }

            is Result.OnError -> {
            }

            is Result.InProgress -> {
            }
        }
    }

    override suspend fun getPostView(
        postToken: String?
    ): Flow<Result<PostDetailsDto>> = flow {
        emit(Result.InProgress(true))

        when (val result = remoteDataSource.getPostView(postToken)) {
            is Result.OnSuccess -> {
                emit(Result.InProgress(false))
                emit(Result.OnSuccess(result.data))
            }

            is Result.OnError -> {
                emit(Result.InProgress(false))
                emit(Result.OnError(result.msg))
            }

            is Result.InProgress -> {}
        }
    }
}