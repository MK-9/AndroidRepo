package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.model.Result
import ir.divar.androidtask.data.model.dto.CityDto
import ir.divar.androidtask.data.model.request.FindPlaceRequest
import ir.divar.androidtask.data.model.response.PlaceListDto

interface PlaceRemoteDataSource {
    suspend fun getPlaceList(accessToken: String?): Result<PlaceListDto>
    
    suspend fun findPlace(accessToken: String?, body: FindPlaceRequest): Result<CityDto>
}