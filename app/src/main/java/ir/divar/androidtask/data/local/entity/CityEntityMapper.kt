package ir.divar.androidtask.data.local.entity

import ir.divar.androidtask.data.model.Centroid
import ir.divar.androidtask.data.model.City
import ir.divar.androidtask.data.network.models.CentroidDto
import ir.divar.androidtask.data.network.models.CityDto

object CityEntityMapper {

    ////////////// ENTITY ---> DTO //////////////
    fun CityEntity.toCityDto() = CityDto(
        name = name, id = id, slug = slug, radius = radius, centroid = centroid?.toCentroidDto()
    )

    private fun CentroidEntity.toCentroidDto() = CentroidDto(
        latitude = latitude, longitude = longitude
    )

    ////////////// DTO ---> ENTITY //////////////
    fun CityDto.toCityEntity() = CityEntity(
        name = name, id = id, slug = slug, radius = radius, centroid = centroid?.toCentroidEntity()
    )

    private fun CentroidDto.toCentroidEntity() = CentroidEntity(
        latitude = latitude, longitude = longitude
    )

    ////////////// ENTITY ---> EXTERNAL MODEL //////////////
    fun CityEntity.toCityExternalModel() = City(
        name = name,
        id = id,
        slug = slug,
        radius = radius,
        centroid = centroid?.toCentroidExternalModel()
    )

    private fun CentroidEntity.toCentroidExternalModel() = Centroid(
        latitude = latitude, longitude = longitude
    )
}