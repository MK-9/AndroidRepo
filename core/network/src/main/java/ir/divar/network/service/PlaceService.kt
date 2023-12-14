package ir.divar.network.service

import ir.divar.network.models.CityDto
import ir.divar.network.models.PlaceListDto
import ir.divar.network.models.request.FindPlaceRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface PlaceService {

    @Headers("Content-Type:application/json")
    @GET("place/list")
    suspend fun getPlaceList(): Response<PlaceListDto>

    @POST("place/find")
    suspend fun findPlace(@Body body: FindPlaceRequest): Response<CityDto>
}