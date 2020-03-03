package app.oneecom.category.ui.viewholders

import androidx.recyclerview.widget.RecyclerView
import app.oneecom.category.databinding.ItemProductBinding
import app.oneecom.core.network.responses.Product

class ItemProductVH(private val binding: ItemProductBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        product: Product,
        onItemClick: (Product) -> Unit
    ) {
        binding.product = product
        binding.root.setOnClickListener { onItemClick(product) }
    }
}