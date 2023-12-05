package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.local.entity.CityEntity
import kotlinx.coroutines.flow.Flow

interface PlaceLocalDataSource {
    suspend fun getCityList(): Flow<List<CityEntity>>

    suspend fun updateCities(cities: List<CityEntity>)
}