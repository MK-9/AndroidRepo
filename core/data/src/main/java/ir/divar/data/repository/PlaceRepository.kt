package ir.divar.data.repository

import ir.divar.common.Result
import ir.divar.model.City
import ir.divar.model.PlaceList
import ir.divar.network.models.request.FindPlaceRequest
import kotlinx.coroutines.flow.Flow

interface PlaceRepository {
    suspend fun getPlaceList(): Flow<Result<PlaceList>>

    suspend fun syncPlaceList()

    suspend fun findPlace(body: FindPlaceRequest): Flow<Result<City>>
}