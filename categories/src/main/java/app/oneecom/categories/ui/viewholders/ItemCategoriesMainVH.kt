package app.oneecom.categories.ui.viewholders

import androidx.recyclerview.widget.RecyclerView
import app.oneecom.categories.databinding.ItemCategoryMainBinding
import app.oneecom.core.network.responses.Category

class ItemCategoriesMainVH(val binding: ItemCategoryMainBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(category: Category) {
        binding.category = category
    }
}