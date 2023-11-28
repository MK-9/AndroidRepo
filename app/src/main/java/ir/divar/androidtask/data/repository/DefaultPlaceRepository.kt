package ir.divar.androidtask.data.repository

import ir.divar.androidtask.data.datasource.PlaceRemoteDataSource
import ir.divar.androidtask.data.model.Result
import ir.divar.androidtask.data.model.dto.CityDto
import ir.divar.androidtask.data.model.request.FindPlaceRequest
import ir.divar.androidtask.data.model.response.PlaceListDto
import javax.inject.Inject

class DefaultPlaceRepository @Inject constructor(val remoteDataSource: PlaceRemoteDataSource) :
    PlaceRepository {

    override suspend fun getPlaceList(accessToken: String?): Result<PlaceListDto> {
        return remoteDataSource.getPlaceList(accessToken)
    }

    override suspend fun findPlace(accessToken: String?, body: FindPlaceRequest): Result<CityDto> {
        return remoteDataSource.findPlace(accessToken, body)
    }
}