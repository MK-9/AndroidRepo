package ir.divar.model.newmodel

data class PostDetailsModel(
    val id: Long = 0,
    val widgets: List<PostDetailsWidgetModel>?,
    val enableContact: Boolean,
    val contactButtonText: String?
)
