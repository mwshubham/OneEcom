package app.oneecom.core.network.responses

data class Product(
    val id: Int,
    val name: String,
    val imageUrl: String?,
    val child: List<Product>?
)