package ir.divar.androidtask.data.local.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.divar.androidtask.data.local.entity.CityEntity
import ir.divar.androidtask.data.local.entity.PostEntity

@Database(entities = [PostEntity::class, CityEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao

    abstract fun cityDao(): CityDao
}