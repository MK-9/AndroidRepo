package ir.divar.androidtask.data.repository

import ir.divar.androidtask.data.model.Result
import ir.divar.androidtask.data.model.dto.CityDto
import ir.divar.androidtask.data.model.request.FindPlaceRequest
import ir.divar.androidtask.data.model.dto.PlaceListDto
import kotlinx.coroutines.flow.Flow

interface PlaceRepository {
    suspend fun getPlaceList(accessToken: String?): Flow<Result<PlaceListDto>>

    suspend fun findPlace(accessToken: String?, body: FindPlaceRequest): Flow<Result<CityDto>>
}