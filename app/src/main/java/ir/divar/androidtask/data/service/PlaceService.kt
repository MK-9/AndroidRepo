package ir.divar.androidtask.data.service

import ir.divar.androidtask.data.model.dto.CityDto
import ir.divar.androidtask.data.model.request.FindPlaceRequest
import ir.divar.androidtask.data.model.response.PlaceListDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface PlaceService {
    @GET("list")
    suspend fun getPlaceList(): Response<PlaceListDto>

    @GET("find")
    suspend fun findPlace(@Body body: FindPlaceRequest): Response<CityDto>
}