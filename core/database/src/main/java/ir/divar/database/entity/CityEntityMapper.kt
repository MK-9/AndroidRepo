package ir.divar.database.entity

import ir.divar.model.Centroid
import ir.divar.model.City

/**
 *  ENTITY ---> EXTERNAL MODEL
 */
object CityEntityMapper {
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
