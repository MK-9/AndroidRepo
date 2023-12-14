package ir.divar.database.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.divar.database.entity.CityEntity
import ir.divar.database.entity.PostEntity

@Database(entities = [PostEntity::class, CityEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao

    abstract fun cityDao(): CityDao
}