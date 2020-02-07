package app.oneecom.navigation

import android.content.Context
import android.content.Intent

object HomeActions : Actions {
    fun openHomePageActivity(context: Context) = internalIntent(
        context,
        "action.oneecom.home.open",
        _flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
    )
}