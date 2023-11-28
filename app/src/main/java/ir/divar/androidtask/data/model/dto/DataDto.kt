package ir.divar.androidtask.data.model.dto

import com.google.gson.annotations.SerializedName

data class DataDto(
    @SerializedName("title") val title: String?,
    @SerializedName("subtitle") val subtitle: String?,
    @SerializedName("text") val text: String?,
    @SerializedName("value") val value: String?,
    @SerializedName("token") val token: String?,
    @SerializedName("price") val price: String?,
    @SerializedName("city") val city: String?,
    @SerializedName("district") val district: String?,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("show_thumbnail") val showThumbnail: Boolean?,
    @SerializedName("thumbnail") val thumbnail: String?,
    @SerializedName("items") val items: List<ItemDto>?,
)