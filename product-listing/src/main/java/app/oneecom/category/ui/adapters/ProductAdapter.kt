package app.oneecom.category.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import app.oneecom.category.R
import app.oneecom.category.ui.viewholders.ItemProductVH
import app.oneecom.core.network.responses.Product

class ProductAdapter(
    context: Context,
    private val productList: List<Product>,
    private val onItemClick: (Product) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemProductVH(
            DataBindingUtil.inflate(
                inflater,
                R.layout.item_product,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemProductVH).bind(productList[position], onItemClick)
    }
}