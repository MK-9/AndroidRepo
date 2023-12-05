package ir.divar.androidtask.data.network.models

import com.google.gson.annotations.SerializedName

data class CentroidDto(
    @SerializedName("latitude") val latitude: Double?,
    @SerializedName("longitude") val longitude: Double?
)