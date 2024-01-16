package ir.divar.data.repository

import ir.divar.common.Result
import ir.divar.data.datasource.PlaceLocalDataSource
import ir.divar.data.datasource.PlaceRemoteDataSource
import ir.divar.data.repository.mapper.CityNetworkMapper.toCityEntity
import ir.divar.database.new_entity.ExternalModelMapper.toCityExternalModel
import ir.divar.model.newmodel.CityModel
import ir.divar.network.models.CityDto
import ir.divar.network.models.request.FindPlaceRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultPlaceRepository @Inject constructor(
    private val remoteDataSource: PlaceRemoteDataSource,
    private val localDataSource: PlaceLocalDataSource
) : PlaceRepository {

    override suspend fun getPlaceList(): Flow<Result<List<CityModel>>> {
        return localDataSource.getCityList().map { cities ->
            Result.OnSuccess(cities.map { it.toCityExternalModel() })
        }
    }

    override suspend fun syncPlaceList() {
        when (val result = remoteDataSource.getPlaceList()) {
            is Result.OnSuccess -> {
                val cities: List<CityDto>? = result.data.cities
                cities?.map { it.toCityEntity() }?.run {
                    localDataSource.updateCities(this)
                }
            }

            is Result.OnError -> {
            }

            is Result.InProgress -> {
            }
        }
    }


    override suspend fun findPlace(body: FindPlaceRequest): Flow<Result<CityModel>> = flow {
        when (val result = remoteDataSource.findPlace(body)) {
            is Result.OnSuccess -> {
                emit(Result.InProgress(false))

                //todo soltan
//                emit(Result.OnSuccess(result.data))
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