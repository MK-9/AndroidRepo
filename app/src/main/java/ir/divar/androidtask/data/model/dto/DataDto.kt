package ir.divar.androidtask.data.model.dto

import com.google.gson.annotations.SerializedName

data class DataDto(
    @SerializedName("title") val title: String?,
    @SerializedName("token") val token: String?,
    @SerializedName("price") val price: String?,
    @SerializedName("subtitle") val subtitle: String?,
    @SerializedName("thumbnail") val thumbnail: String?,
    @SerializedName("city") val city: String?,
    @SerializedName("district") val district: String?
)