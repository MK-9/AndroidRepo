package ir.divar.androidtask.data.repository

import ir.divar.androidtask.data.datasource.PostRemoteDataSource
import ir.divar.androidtask.data.model.Result
import ir.divar.androidtask.data.model.request.PostListRequest
import ir.divar.androidtask.data.model.response.PostDetailsDto
import ir.divar.androidtask.data.model.response.PostsDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultPostRepository @Inject constructor(private val remoteDataSource: PostRemoteDataSource) :
    PostRepository {

    override suspend fun getPostList(
        accessToken: String?, selectedCityId: Int, body: PostListRequest
    ): Flow<Result<PostsDto>> = flow {
        emit(Result.InProgress(true))

        when (val result = remoteDataSource.getPostList(accessToken, selectedCityId, body)) {
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

    override suspend fun getPostView(
        accessToken: String?, postToken: String?
    ): Flow<Result<PostDetailsDto>> = flow {
        emit(Result.InProgress(true))

        when (val result = remoteDataSource.getPostView(accessToken, postToken)) {
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