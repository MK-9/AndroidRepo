package ir.divar.data.repository

import ir.divar.network.models.CityDto
import ir.divar.network.models.PlaceListDto
import ir.divar.network.models.request.FindPlaceRequest
import kotlinx.coroutines.flow.Flow

interface PlaceRepository {
    suspend fun getPlaceList(): Flow<Result<PlaceListDto>>

    suspend fun syncPlaceList()

    suspend fun findPlace(body: FindPlaceRequest): Flow<Result<CityDto>>
}