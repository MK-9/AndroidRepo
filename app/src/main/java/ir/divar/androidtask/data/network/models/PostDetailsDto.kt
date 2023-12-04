package ir.divar.androidtask.data.network.models

import com.google.gson.annotations.SerializedName

data class PostDetailsDto(
    @SerializedName("widgets") val widgets: List<PostDto>?,
    @SerializedName("enable_contact") val enableContact: Boolean,
    @SerializedName("contact_button_text") val contactButtonText: String?
)