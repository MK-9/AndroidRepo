package ir.divar.network.models

import com.google.gson.annotations.SerializedName

data class PostDataDto(
    @SerializedName("title") val title: String?,
    @SerializedName("subtitle") val subtitle: String?,
    @SerializedName("text") val text: String?,
    @SerializedName("value") val value: String?,
    @SerializedName("token") val token: String?,
    @SerializedName("price") val price: String?,
    @SerializedName("city") val city: String?,
    @SerializedName("district") val district: String?,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("show_thumbnail") val showThumbnail: Boolean = false,
    @SerializedName("thumbnail") val thumbnail: String?,
    @SerializedName("items") val items: List<ImageItemDto>?,
) {
    override fun toString(): String {
        return "DataDto(title=$title, subtitle=$subtitle, text=$text, value=$value, token=$token, price=$price, city=$city, district=$district, imageUrl=$imageUrl, showThumbnail=$showThumbnail, thumbnail=$thumbnail, items=$items)"
    }
}