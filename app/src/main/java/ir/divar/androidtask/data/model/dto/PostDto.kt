package ir.divar.androidtask.data.model.dto

import com.google.gson.annotations.SerializedName

data class PostDto(
    @SerializedName("widget_type") val widgetType: String?,
    @SerializedName("data") val data: PostDataDto?
)
