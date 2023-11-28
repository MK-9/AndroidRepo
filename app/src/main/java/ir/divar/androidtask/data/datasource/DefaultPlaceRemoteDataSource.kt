package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.model.Result
import ir.divar.androidtask.data.model.dto.CityDto
import ir.divar.androidtask.data.model.request.FindPlaceRequest
import ir.divar.androidtask.data.model.response.PlaceListDto
import ir.divar.androidtask.data.service.PlaceService
import javax.inject.Inject

class DefaultPlaceRemoteDataSource @Inject constructor(val service: PlaceService) :
    PlaceRemoteDataSource {

    override suspend fun getPlaceList(accessToken: String?): Result<PlaceListDto> {
        return safeApiCall {
            service.getPlaceList(accessToken)
        }
    }

    override suspend fun findPlace(accessToken: String?, body: FindPlaceRequest): Result<CityDto> {
        return safeApiCall {
            service.findPlace(accessToken, body)
        }
    }
}