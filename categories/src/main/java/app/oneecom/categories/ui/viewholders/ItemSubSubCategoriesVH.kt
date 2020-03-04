package app.oneecom.categories.ui.viewholders

import androidx.recyclerview.widget.RecyclerView
import app.oneecom.categories.databinding.ItemSubSubCategoryBinding
import app.oneecom.core.network.responses.Category

class ItemSubSubCategoriesVH(private val binding: ItemSubSubCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        category: Category,
        onItemClickListener: (Category) -> Unit
    ) {
        binding.category = category
        binding.root.setOnClickListener { onItemClickListener(category) }
    }
}