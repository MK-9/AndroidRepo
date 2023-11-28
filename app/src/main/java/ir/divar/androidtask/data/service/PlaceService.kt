package ir.divar.androidtask.data.service

import ir.divar.androidtask.data.model.dto.CityDto
import ir.divar.androidtask.data.model.request.FindPlaceRequest
import ir.divar.androidtask.data.model.response.PlaceListDto
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