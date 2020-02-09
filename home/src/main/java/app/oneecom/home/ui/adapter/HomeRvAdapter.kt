package app.oneecom.home.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import app.oneecom.core.constants.CoreLoggingConstants
import app.oneecom.home.R
import app.oneecom.home.ui.viewholder.ItemHomeBannerOneVH
import timber.log.Timber

class HomeRvAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    init {
        Timber.i(CoreLoggingConstants.LOGGING_PLACEHOLDER)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemHomeBannerOneVH(
            DataBindingUtil.inflate(
                inflater,
                R.layout.item_home_banner_one,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = 10

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemHomeBannerOneVH -> holder.bind()
        }
    }

}
