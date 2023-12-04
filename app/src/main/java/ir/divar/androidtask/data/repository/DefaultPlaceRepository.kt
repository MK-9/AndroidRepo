package ir.divar.androidtask.data.repository

import android.util.Log
import ir.divar.androidtask.data.datasource.PlaceLocalDataSource
import ir.divar.androidtask.data.datasource.PlaceRemoteDataSource
import ir.divar.androidtask.data.network.models.CityDto
import ir.divar.androidtask.data.network.models.PlaceListDto
import ir.divar.androidtask.data.network.models.Result
import ir.divar.androidtask.data.network.models.request.FindPlaceRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultPlaceRepository @Inject constructor(
    private val remoteDataSource: PlaceRemoteDataSource,
    private val localDataSource: PlaceLocalDataSource
) : PlaceRepository {

    override suspend fun getPlaceList(accessToken: String?): Flow<Result<PlaceListDto>> = flow {
        emit(Result.InProgress(true))


//        val localResult = localDataSource.getCityList()
//        emit(Result.OnSuccess(PlaceListDto(cities = localResult)))


        when (val result = remoteDataSource.getPlaceList(accessToken)) {
            is Result.OnSuccess -> {
                emit(Result.InProgress(false))
                emit(Result.OnSuccess(result.data))


                result.data.cities?.forEach {
                    localDataSource.insertCity(it)
                }

                val cities = localDataSource.getCityList()
                Log.d("getPostList", "size-------:${cities.size}")
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