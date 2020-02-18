package app.oneecom.categories.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import app.oneecom.categories.R
import app.oneecom.categories.ui.viewholders.ItemCategoriesMainVH
import app.oneecom.categories.ui.viewholders.ItemSubCategoriesVH
import app.oneecom.categories.ui.viewmodels.CategoriesViewModel
import app.oneecom.core.constants.CoreLoggingConstants
import app.oneecom.core.network.responses.Category
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import timber.log.Timber

class CategoriesMainAdapter(
    context: Context,
    private val viewModel: CategoriesViewModel,
    categoryList: List<Category>,
    private val onChildItemClickListener: (Category) -> Unit
) :
    ExpandableRecyclerViewAdapter<ItemCategoriesMainVH, ItemSubCategoriesVH>(categoryList) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    init {
        Timber.i(CoreLoggingConstants.LOGGING_PLACEHOLDER)
    }

    override fun onCreateGroupViewHolder(parent: ViewGroup?, viewType: Int): ItemCategoriesMainVH {
        return ItemCategoriesMainVH(
            DataBindingUtil.inflate(
                inflater,
                R.layout.item_category_main,
                parent,
                false
            )
        )
    }

    override fun onCreateChildViewHolder(parent: ViewGroup?, viewType: Int): ItemSubCategoriesVH {
        return ItemSubCategoriesVH(
            DataBindingUtil.inflate(
                inflater,
                R.layout.item_sub_category,
                parent,
                false
            )
        )
    }

    override fun onBindGroupViewHolder(
        holder: ItemCategoriesMainVH,
        flatPosition: Int,
        group: ExpandableGroup<*>
    ) {
        holder.bind(group as Category)
    }

    override fun onBindChildViewHolder(
        holder: ItemSubCategoriesVH,
        flatPosition: Int,
        group: ExpandableGroup<*>,
        childIndex: Int
    ) {
        holder.bind(group, childIndex, onChildItemClickListener, viewModel)
    }
}

