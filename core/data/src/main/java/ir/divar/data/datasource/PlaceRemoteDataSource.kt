package ir.divar.data.datasource

import ir.divar.network.models.CityDto
import ir.divar.network.models.PlaceListDto
import ir.divar.network.models.request.FindPlaceRequest
import ir.divar.common.Result

interface PlaceRemoteDataSource {
    suspend fun getPlaceList(): Result<PlaceListDto>

    suspend fun findPlace(body: FindPlaceRequest): Result<CityDto>
}