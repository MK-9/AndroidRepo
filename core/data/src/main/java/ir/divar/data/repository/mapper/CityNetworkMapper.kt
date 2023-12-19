package ir.divar.data.repository.mapper

import ir.divar.database.entity.CentroidEntity
import ir.divar.database.entity.CityEntity
import ir.divar.network.models.CentroidDto
import ir.divar.network.models.CityDto

/**
 *  Network ---> Entity
 */
object CityNetworkMapper {
    fun CityDto.toCityEntity() = CityEntity(
        name = name, id = id, slug = slug, radius = radius, centroid = centroid?.toCentroidEntity()
    )

    private fun CentroidDto.toCentroidEntity() = CentroidEntity(
        latitude = latitude, longitude = longitude
    )
}