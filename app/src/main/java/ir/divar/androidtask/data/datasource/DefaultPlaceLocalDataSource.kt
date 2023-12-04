package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.local.dao.CityDao
import ir.divar.androidtask.data.local.entity.CityEntityMapper.toCityDto
import ir.divar.androidtask.data.local.entity.CityEntityMapper.toCityEntity
import ir.divar.androidtask.data.network.models.CityDto
import ir.divar.androidtask.data.repository.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultPlaceLocalDataSource @Inject constructor(
    private val dispatcher: DispatcherProvider,
    private val dao: CityDao
) : PlaceLocalDataSource {

    override suspend fun getCityList(): List<CityDto> {
        return withContext(dispatcher.io()) {
            dao.getAllCities().map { it.toCityDto() }
        }
    }

    override suspend fun insertCity(post: CityDto) {
        return withContext(dispatcher.io()) {
            dao.insertCity(post.toCityEntity())
        }
    }
}