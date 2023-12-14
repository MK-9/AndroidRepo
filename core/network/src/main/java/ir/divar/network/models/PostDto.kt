package ir.divar.network.models

import com.google.gson.annotations.SerializedName

data class PostDto(
    @SerializedName("widget_type") val widgetType: String?,
    @SerializedName("data") val data: PostDataDto?
)
