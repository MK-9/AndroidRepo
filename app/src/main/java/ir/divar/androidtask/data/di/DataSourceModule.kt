package ir.divar.androidtask.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.divar.androidtask.data.datasource.DefaultPlaceRemoteDataSource
import ir.divar.androidtask.data.datasource.DefaultPostRemoteDataSource
import ir.divar.androidtask.data.datasource.PlaceRemoteDataSource
import ir.divar.androidtask.data.datasource.PostRemoteDataSource

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
    @Binds
    fun bindPostRemoteDataSource(remoteDataSource: DefaultPostRemoteDataSource): PostRemoteDataSource

    @Binds
    fun bindListRemoteDataSource(remoteDataSource: DefaultPlaceRemoteDataSource): PlaceRemoteDataSource

}