package ir.divar.androidtask.data.model.dto

import com.google.gson.annotations.SerializedName

data class WidgetDto(
    @SerializedName("widget_type") val widgetType: String?,
    @SerializedName("data") val data: WidgetDataDto?
)
