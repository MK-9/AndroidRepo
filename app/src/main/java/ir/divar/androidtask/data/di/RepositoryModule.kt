package ir.divar.androidtask.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.divar.androidtask.data.repository.DefaultPlaceRepository
import ir.divar.androidtask.data.repository.DefaultPostRepository
import ir.divar.androidtask.data.repository.PlaceRepository
import ir.divar.androidtask.data.repository.PostRepository

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindPlaceRepository(repository: DefaultPlaceRepository): PlaceRepository

    @Binds
    fun bindPostRepository(repository: DefaultPostRepository): PostRepository
}