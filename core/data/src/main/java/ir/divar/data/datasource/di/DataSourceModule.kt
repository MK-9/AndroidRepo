package ir.divar.data.datasource.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.divar.data.datasource.DefaultPlaceLocalDataSource
import ir.divar.data.datasource.DefaultPlaceRemoteDataSource
import ir.divar.data.datasource.DefaultPostLocalDataSource
import ir.divar.data.datasource.DefaultPostRemoteDataSource
import ir.divar.data.datasource.PlaceLocalDataSource
import ir.divar.data.datasource.PlaceRemoteDataSource
import ir.divar.data.datasource.PostLocalDataSource
import ir.divar.data.datasource.PostRemoteDataSource
import ir.divar.data.repository.DefaultDispatcherProvider
import ir.divar.data.repository.DispatcherProvider

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
    @Binds
    fun bindPostRemoteDataSource(remoteDataSource: DefaultPostRemoteDataSource): PostRemoteDataSource

    @Binds
    fun bindPostLocalDataSource(localDataSource: DefaultPostLocalDataSource): PostLocalDataSource

    @Binds
    fun bindPlaceListRemoteDataSource(remoteDataSource: DefaultPlaceRemoteDataSource): PlaceRemoteDataSource

    @Binds
    fun bindPlaceListLocalDataSource(localDataSource: DefaultPlaceLocalDataSource): PlaceLocalDataSource

    @Binds
    fun provideDispatchersProvider(provider: DefaultDispatcherProvider): DispatcherProvider
}