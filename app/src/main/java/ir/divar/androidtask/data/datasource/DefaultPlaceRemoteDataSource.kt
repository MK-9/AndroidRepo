package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.model.Result
import ir.divar.androidtask.data.model.dto.CityDto
import ir.divar.androidtask.data.model.request.FindPlaceRequest
import ir.divar.androidtask.data.model.dto.PlaceListDto
import ir.divar.androidtask.data.repository.DispatcherProvider
import ir.divar.androidtask.data.service.PlaceService
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultPlaceRemoteDataSource @Inject constructor(
    private val dispatcher: DispatcherProvider,
    private val service: PlaceService
) : PlaceRemoteDataSource {

    override suspend fun getPlaceList(accessToken: String?): Result<PlaceListDto> {
        return withContext(dispatcher.io()) {
            safeApiCall {
                service.getPlaceList(accessToken)
            }
        }
    }

    override suspend fun findPlace(accessToken: String?, body: FindPlaceRequest): Result<CityDto> {
        return withContext(dispatcher.io()) {
            safeApiCall {
                service.findPlace(accessToken, body)
            }
        }
    }
}