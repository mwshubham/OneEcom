package app.oneecom.categories.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import app.oneecom.categories.R
import app.oneecom.categories.ui.viewholders.ItemSubSubCategoriesVH
import app.oneecom.core.constants.CoreLoggingConstants
import app.oneecom.core.network.responses.Category
import timber.log.Timber

class SubSubCategoriesAdapter(context: Context, val categories: List<Category>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    init {
        Timber.i(CoreLoggingConstants.LOGGING_PLACEHOLDER)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemSubSubCategoriesVH(
            DataBindingUtil.inflate(
                inflater,
                R.layout.item_sub_sub_category,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemSubSubCategoriesVH -> holder.bind(categories[position])
        }
    }
}