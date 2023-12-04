package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.network.models.Result
import ir.divar.androidtask.data.network.models.CityDto
import ir.divar.androidtask.data.network.models.request.FindPlaceRequest
import ir.divar.androidtask.data.network.models.PlaceListDto

interface PlaceRemoteDataSource {
    suspend fun getPlaceList(accessToken: String?): Result<PlaceListDto>
    
    suspend fun findPlace(accessToken: String?, body: FindPlaceRequest): Result<CityDto>
}