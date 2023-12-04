package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.network.models.CityDto
import ir.divar.androidtask.data.network.models.PlaceListDto
import ir.divar.androidtask.data.network.models.Result
import ir.divar.androidtask.data.network.models.request.FindPlaceRequest

interface PlaceRemoteDataSource {
    suspend fun getPlaceList(): Result<PlaceListDto>

    suspend fun findPlace(body: FindPlaceRequest): Result<CityDto>
}