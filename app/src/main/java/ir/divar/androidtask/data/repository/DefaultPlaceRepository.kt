package ir.divar.androidtask.data.repository

import ir.divar.androidtask.data.datasource.PlaceLocalDataSource
import ir.divar.androidtask.data.datasource.PlaceRemoteDataSource
import ir.divar.database.entity.CityEntityMapper.toCityDto
import ir.divar.database.entity.CityEntityMapper.toCityEntity
import ir.divar.androidtask.data.network.models.CityDto
import ir.divar.androidtask.data.network.models.PlaceListDto
import ir.divar.androidtask.data.network.models.Result
import ir.divar.androidtask.data.network.models.request.FindPlaceRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultPlaceRepository @Inject constructor(
    private val remoteDataSource: PlaceRemoteDataSource,
    private val localDataSource: PlaceLocalDataSource
) : PlaceRepository {

    override suspend fun getPlaceList(): Flow<Result<PlaceListDto>> {
        return localDataSource.getCityList()
            .map { cities ->
                val placeListDto = PlaceListDto(cities.map { it.toCityDto() })
                Result.OnSuccess(placeListDto)
            }
    }

    override suspend fun syncPlaceList() {
        when (val result = remoteDataSource.getPlaceList()) {
            is Result.OnSuccess -> {
                result.data.cities?.map { it.toCityEntity() }?.run {
                    localDataSource.updateCities(this)
                }
            }

            is Result.OnError -> {
            }

            is Result.InProgress -> {
            }
        }
    }


    override suspend fun findPlace(
        body: FindPlaceRequest
    ): Flow<Result<CityDto>> = flow {
        when (val result = remoteDataSource.findPlace(body)) {
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