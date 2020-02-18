package app.oneecom.categories.ui.viewholders

import app.oneecom.categories.databinding.ItemSubCategoryBinding
import app.oneecom.categories.ui.viewmodels.CategoriesViewModel
import app.oneecom.core.network.responses.Category
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder

class ItemSubCategoriesVH(private val binding: ItemSubCategoryBinding) :
    ChildViewHolder(binding.root) {

    fun bind(
        group: ExpandableGroup<*>,
        childIndex: Int,
        onChildItemClickListener: (Category) -> Unit,
        viewModel: CategoriesViewModel
    ) {
        val parentCategory = group as Category
        val category = group.items[childIndex] as Category
        binding.category = category
        binding.root.setOnClickListener {
            viewModel.onSubCategorySelected(parentCategory, category)
            onChildItemClickListener(category)
        }
    }

}