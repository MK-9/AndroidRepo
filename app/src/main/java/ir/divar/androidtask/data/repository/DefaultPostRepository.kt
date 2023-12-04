package ir.divar.androidtask.data.repository

import android.util.Log
import ir.divar.androidtask.data.datasource.PostLocalDataSource
import ir.divar.androidtask.data.datasource.PostRemoteDataSource
import ir.divar.androidtask.data.network.models.Result
import ir.divar.androidtask.data.network.models.request.PostListRequest
import ir.divar.androidtask.data.network.models.PostDetailsDto
import ir.divar.androidtask.data.network.models.PostsDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultPostRepository @Inject constructor(
    private val remoteDataSource: PostRemoteDataSource,
    private val localDataSource: PostLocalDataSource
) : PostRepository {

    override suspend fun getPostList(
        selectedCityId: Int, body: PostListRequest
    ): Flow<Result<PostsDto>> = flow {
        emit(Result.InProgress(true))

//        val localResult = localDataSource.getPostList()
//        emit(Result.OnSuccess(PostsDto(widgets = localResult, lastPostDate = "")))

//        if (localResult != null){
//            emit(Result.OnSuccess(localResult.))
//        }

        when (val result = remoteDataSource.getPostList(selectedCityId, body)) {
            is Result.OnSuccess -> {
                emit(Result.InProgress(false))
                emit(Result.OnSuccess(result.data))

                result.data.widgets?.forEach {
                    localDataSource.insertPost(it)
                }

                val users = localDataSource.getPostList()
                Log.d("getPostList", "size-------:${users.size}")
            }

            is Result.OnError -> {
                emit(Result.InProgress(false))
                emit(Result.OnError(result.msg))
            }

            is Result.InProgress -> {}
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