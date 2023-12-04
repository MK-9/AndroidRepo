package ir.divar.androidtask.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import ir.divar.androidtask.data.local.entity.CityEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {
    @Insert
    suspend fun insertCities(cityEntity: List<CityEntity>)

    @Transaction
    suspend fun updateCity(cities: List<CityEntity>) {
        deleteCities()
        insertCities(cities)
    }

    @Query("DELETE FROM CITYENTITY")
    suspend fun deleteCities()

    @Query("SELECT * FROM CityEntity")
    fun getAllCities(): Flow<List<CityEntity>>
}