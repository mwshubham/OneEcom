package app.oneecom.categories.ui.viewholders

import app.oneecom.categories.databinding.ItemSubCategoryBinding
import app.oneecom.core.network.responses.Category
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder

class ItemSubCategoriesVH(private val binding: ItemSubCategoryBinding) :
    ChildViewHolder(binding.root) {

    fun bind(category: Category) {
        binding.category = category
    }
}