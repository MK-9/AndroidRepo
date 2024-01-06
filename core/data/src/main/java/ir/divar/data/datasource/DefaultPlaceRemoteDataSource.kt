package ir.divar.data.datasource

import ir.divar.common.Result
import ir.divar.data.repository.DispatcherProvider
import ir.divar.network.models.CityDto
import ir.divar.network.models.PlaceListDto
import ir.divar.network.models.request.FindPlaceRequest
import ir.divar.network.service.PlaceService
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultPlaceRemoteDataSource @Inject constructor(
    private val dispatcher: DispatcherProvider,
    private val service: PlaceService
) : PlaceRemoteDataSource {

    override suspend fun getPlaceList(): Result<PlaceListDto> {
        return withContext(dispatcher.io()) {
            safeApiCall {
                service.getPlaceList()
            }
        }
    }

    override suspend fun findPlace(body: FindPlaceRequest): Result<CityDto> {
        return withContext(dispatcher.io()) {
            safeApiCall {
                service.findPlace(body)
            }
        }
    }
}