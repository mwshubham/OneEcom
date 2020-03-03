package app.oneecom.navigation

import android.content.Context
import android.content.Intent

object ProductListingActions : Actions {

    fun getProductListingActivityIntent(context: Context) = internalIntent(
        context,
        "action.oneecom.product-listing.open",
        _flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
    )
}