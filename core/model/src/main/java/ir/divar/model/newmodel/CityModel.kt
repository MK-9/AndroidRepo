package ir.divar.model.newmodel

data class CityModel(
    val id: Int?,
    val name: String?,
    val slug: String?,
    val radius: Int?,
    val centroid: CentroidModel?
)

