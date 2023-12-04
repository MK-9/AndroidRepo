package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.network.models.CityDto

interface PlaceLocalDataSource {
    suspend fun getCityList(): List<CityDto>

    suspend fun insertCity(post: CityDto)
}