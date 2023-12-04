package ir.divar.androidtask.data.datasource.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.divar.androidtask.data.datasource.DefaultPlaceRemoteDataSource
import ir.divar.androidtask.data.datasource.DefaultPostLocalDataSource
import ir.divar.androidtask.data.datasource.DefaultPostRemoteDataSource
import ir.divar.androidtask.data.datasource.PlaceRemoteDataSource
import ir.divar.androidtask.data.datasource.PostLocalDataSource
import ir.divar.androidtask.data.datasource.PostRemoteDataSource
import ir.divar.androidtask.data.repository.DefaultDispatcherProvider
import ir.divar.androidtask.data.repository.DispatcherProvider

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
    @Binds
    fun bindPostRemoteDataSource(remoteDataSource: DefaultPostRemoteDataSource): PostRemoteDataSource

    @Binds
    fun bindPostLocalDataSource(localDataSource: DefaultPostLocalDataSource): PostLocalDataSource

    @Binds
    fun bindListRemoteDataSource(remoteDataSource: DefaultPlaceRemoteDataSource): PlaceRemoteDataSource

    @Binds
    fun provideDispatchersProvider(provider: DefaultDispatcherProvider): DispatcherProvider
}