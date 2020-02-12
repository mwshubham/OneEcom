package app.oneecom.core.network.responses

data class Category(
    val id: Int,
    val name: String,
    val child: List<Category>?
)