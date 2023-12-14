package ir.divar.androidtask.data.datasource

import ir.divar.database.entity.CityEntity
import kotlinx.coroutines.flow.Flow

interface PlaceLocalDataSource {
    suspend fun getCityList(): Flow<List<CityEntity>>

    suspend fun updateCities(cities: List<CityEntity>)
}