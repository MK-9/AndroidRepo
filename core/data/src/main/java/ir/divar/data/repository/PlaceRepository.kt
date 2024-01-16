package ir.divar.data.repository

import ir.divar.common.Result
import ir.divar.model.newmodel.CityModel
import ir.divar.network.models.request.FindPlaceRequest
import kotlinx.coroutines.flow.Flow

interface PlaceRepository {
    suspend fun getPlaceList(): Flow<Result<List<CityModel>>>

    suspend fun syncPlaceList()

    suspend fun findPlace(body: FindPlaceRequest): Flow<Result<CityModel>>
}