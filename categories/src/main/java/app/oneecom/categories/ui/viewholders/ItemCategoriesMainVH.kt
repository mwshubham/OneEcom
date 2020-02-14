package app.oneecom.categories.ui.viewholders

import app.oneecom.categories.databinding.ItemCategoryMainBinding
import app.oneecom.core.network.responses.Category
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder

class ItemCategoriesMainVH(private val binding: ItemCategoryMainBinding) :
    GroupViewHolder(binding.root) {

    fun bind(category: Category) {
        binding.category = category
    }
}