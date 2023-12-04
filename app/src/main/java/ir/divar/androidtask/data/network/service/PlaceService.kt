package ir.divar.androidtask.data.network.service

import ir.divar.androidtask.data.network.models.CityDto
import ir.divar.androidtask.data.network.models.request.FindPlaceRequest
import ir.divar.androidtask.data.network.models.PlaceListDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface PlaceService {

    @Headers("Content-Type:application/json")
    @GET("place/list")
    suspend fun getPlaceList(
        @Header("x-access-token") accessToken: String?
    ): Response<PlaceListDto>

    @POST("place/find")
    suspend fun findPlace(
        @Header("x-access-token") accessToken: String?, @Body body: FindPlaceRequest
    ): Response<CityDto>
}