package ir.divar.androidtask.data.local.entity

import ir.divar.androidtask.data.network.models.CentroidDto
import ir.divar.androidtask.data.network.models.CityDto

object CityEntityMapper {
    fun CityEntity.toCityDto() = CityDto(
        name = name, id = id, slug = slug, radius = radius, centroid = centroid?.toCentroidDto()
    )

    private fun CentroidEntity.toCentroidDto() = CentroidDto(
        latitude = latitude, longitude = longitude
    )

    fun CityDto.toCityEntity() = CityEntity(
        name = name, id = id, slug = slug, radius = radius, centroid = centroid?.toCentroidEntity()
    )

    private fun CentroidDto.toCentroidEntity() = CentroidEntity(
        latitude = latitude, longitude = longitude
    )
}