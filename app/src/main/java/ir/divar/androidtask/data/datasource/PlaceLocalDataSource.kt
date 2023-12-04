package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.network.models.CityDto

interface PlaceLocalDataSource {
    suspend fun getPostList(): List<CityDto>

    suspend fun insertPost(post: CityDto)
}