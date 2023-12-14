package ir.divar.model

data class PostDetails(
    val widgets: List<Post>?,
    val enableContact: Boolean,
    val contactButtonText: String?
)
