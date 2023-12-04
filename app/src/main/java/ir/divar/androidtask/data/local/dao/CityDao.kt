package ir.divar.androidtask.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ir.divar.androidtask.data.local.entity.CityEntity

@Dao
interface CityDao {
    @Insert
    fun insertCity(cityEntity: CityEntity)

    @Query("SELECT * FROM CityEntity")
    fun getAllCities(): List<CityEntity>
}