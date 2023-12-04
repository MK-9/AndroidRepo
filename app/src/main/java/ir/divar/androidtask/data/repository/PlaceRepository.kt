package ir.divar.androidtask.data.repository

import ir.divar.androidtask.data.network.models.Result
import ir.divar.androidtask.data.network.models.CityDto
import ir.divar.androidtask.data.network.models.request.FindPlaceRequest
import ir.divar.androidtask.data.network.models.PlaceListDto
import kotlinx.coroutines.flow.Flow

interface PlaceRepository {
    suspend fun getPlaceList(): Flow<Result<PlaceListDto>>

    suspend fun syncPlaceList(accessToken: String?)

    suspend fun findPlace(accessToken: String?, body: FindPlaceRequest): Flow<Result<CityDto>>
}