package ir.divar.androidtask.data.repository

import ir.divar.androidtask.data.datasource.PostLocalDataSource
import ir.divar.androidtask.data.datasource.PostRemoteDataSource
import ir.divar.androidtask.data.local.entity.PostEntityMapper.toPostEntity
import ir.divar.androidtask.data.local.entity.PostEntityMapper.toPostsExternalModel
import ir.divar.androidtask.data.model.Posts
import ir.divar.androidtask.data.network.models.PostDetailsDto
import ir.divar.androidtask.data.network.models.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultPostRepository @Inject constructor(
    private val remoteDataSource: PostRemoteDataSource,
    private val localDataSource: PostLocalDataSource
) : PostRepository {

    override suspend fun filterPosts(cityId: Int): Flow<Result<Posts>> =
        localDataSource.filterPosts(cityId = cityId).map { post ->
            Result.OnSuccess(post.toPostsExternalModel())
        }

    override suspend fun syncPosts(
        cityId: Int, page: Int, lastPostDate: Long
    ): Flow<Result<Posts>> = flow {
        when (val result = remoteDataSource.getPosts(cityId, page, lastPostDate)) {
            is Result.OnSuccess -> {
                result.data.run {
                    toPostEntity(
                        cityId = cityId, page = page.toString()
                    )?.let {
                        localDataSource.updatePosts(it)
                        emit(Result.OnSuccess(it.toPostsExternalModel()))
                    }
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