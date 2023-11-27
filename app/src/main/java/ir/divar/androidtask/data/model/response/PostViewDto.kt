package ir.divar.androidtask.data.model.response

import com.google.gson.annotations.SerializedName
import ir.divar.androidtask.data.model.dto.WidgetDto

data class PostViewDto(
    @SerializedName("widgets") val widgets: List<WidgetDto>,
    @SerializedName("enable_contact") val enableContact: Boolean?,
    @SerializedName("contact_button_text") val contactButtonText: String?
)