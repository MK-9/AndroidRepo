package ir.divar.data.repository.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.divar.data.repository.DefaultPlaceRepository
import ir.divar.data.repository.DefaultPostRepository
import ir.divar.data.repository.PlaceRepository
import ir.divar.data.repository.PostRepository

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindPlaceRepository(repository: DefaultPlaceRepository): PlaceRepository

    @Binds
    fun bindPostRepository(repository: DefaultPostRepository): PostRepository
}