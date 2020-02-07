package app.oneecom.navigation

import android.content.Context
import android.content.Intent
import android.net.Uri

interface Actions {
    fun internalIntent(
        context: Context,
        action: String,
        deepLink: String? = null,
        _flags: Int? = null
    ) = Intent(action).apply {
        setPackage(context.packageName)
        deepLink?.let {
            data = Uri.parse(deepLink)
        }
        _flags?.let {
            flags = _flags
        }
    }
}