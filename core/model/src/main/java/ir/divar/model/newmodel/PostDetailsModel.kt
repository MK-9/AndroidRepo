package ir.divar.model.newmodel

data class PostDetailsModel(
    val id: Int = 0,
    val widgets: List<PostDetailsWidgetModel>?,
    val enableContact: Boolean,
    val contactButtonText: String?
)
