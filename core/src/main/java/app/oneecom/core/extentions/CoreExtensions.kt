package app.oneecom.core.extentions

import timber.log.Timber

/**
 * These extension utils will work with [Any]
 */

val Any.TAG: String
    get() {
        val tag = javaClass.simpleName
        return if (tag.length <= 23) tag else tag.substring(0, 23)
    }

fun Any.log(any: Any) {
    Timber.d(any.toString())
}