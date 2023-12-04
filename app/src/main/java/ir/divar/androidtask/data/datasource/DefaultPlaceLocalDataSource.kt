package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.local.dao.CityDao
import ir.divar.androidtask.data.local.entity.CityEntity
import ir.divar.androidtask.data.repository.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultPlaceLocalDataSource @Inject constructor(
    private val dispatcher: DispatcherProvider,
    private val dao: CityDao
) : PlaceLocalDataSource {

    override suspend fun getCityList(): Flow<List<CityEntity>> {
        return withContext(dispatcher.io()) {
            dao.getAllCities()
        }
    }

    override suspend fun updateCities(cities: List<CityEntity>) {
        return withContext(dispatcher.io()) {
            dao.updateCity(cities)
        }
    }
}