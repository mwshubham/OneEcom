package app.oneecom.core.network.responses

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

data class Category(
    val id: Int,
    val name: String,
    val imageUrl: String?,
    val child: List<Category>?
) : ExpandableGroup<Category>(
    name, child
) {
    fun showExpandIcon() = child.isNullOrEmpty()
}