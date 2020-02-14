package app.oneecom.categories.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import app.oneecom.categories.R
import app.oneecom.categories.ui.viewholders.ItemCategoriesMainVH
import app.oneecom.core.constants.CoreLoggingConstants
import app.oneecom.core.network.responses.Category
import timber.log.Timber

class CategoriesMainAdapter(context: Context, private val categoryList: List<Category>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    init {
        Timber.i(CoreLoggingConstants.LOGGING_PLACEHOLDER)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemCategoriesMainVH(
            DataBindingUtil.inflate(
                inflater,
                R.layout.item_category_main,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = categoryList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemCategoriesMainVH -> holder.bind(categoryList[position])
        }
    }
}
