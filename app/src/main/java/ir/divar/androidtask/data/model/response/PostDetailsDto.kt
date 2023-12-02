package ir.divar.androidtask.data.model.response

import com.google.gson.annotations.SerializedName
import ir.divar.androidtask.data.model.dto.PostDto

data class PostDetailsDto(
    @SerializedName("widgets") val widgets: List<PostDto>?,
    @SerializedName("enable_contact") val enableContact: Boolean,
    @SerializedName("contact_button_text") val contactButtonText: String?
)