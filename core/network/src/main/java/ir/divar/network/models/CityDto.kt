package ir.divar.network.models

import com.google.gson.annotations.SerializedName

data class CityDto(
    @SerializedName("name") val name: String?,
    @SerializedName("id") val id: Int?,
    @SerializedName("slug") val slug: String?,
    @SerializedName("radius") val radius: Int?,
    @SerializedName("centroid") val centroid: CentroidDto?
)
