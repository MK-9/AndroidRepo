package ir.divar.androidtask.data.repository

import ir.divar.androidtask.data.datasource.PlaceRemoteDataSource
import ir.divar.androidtask.data.model.Result
import ir.divar.androidtask.data.model.dto.CityDto
import ir.divar.androidtask.data.model.request.FindPlaceRequest
import ir.divar.androidtask.data.model.response.PlaceListDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultPlaceRepository @Inject constructor(private val remoteDataSource: PlaceRemoteDataSource) :
    PlaceRepository {

    override suspend fun getPlaceList(accessToken: String?): Flow<Result<PlaceListDto>> = flow {
        emit(Result.InProgress(true))

        when (val result = remoteDataSource.getPlaceList(accessToken)) {
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

    override suspend fun findPlace(
        accessToken: String?, body: FindPlaceRequest
    ): Flow<Result<CityDto>> = flow {
        when (val result = remoteDataSource.findPlace(accessToken, body)) {
            is Result.OnSuccess -> {
                emit(Result.InProgress(false))
                emit(Result.OnSuccess(result.data))
            }

            is Result.OnError -> {
                emit(Result.InProgress(false))
                emit(Result.OnError(result.msg))
            }

            is Result.InProgress -> {
                emit(Result.InProgress(true))
            }
        }
    }

}