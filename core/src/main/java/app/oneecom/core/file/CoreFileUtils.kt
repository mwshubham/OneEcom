package app.oneecom.core.file

import app.oneecom.core.CoreApplication

object CoreFileUtils {

    /**
     * @param fileName e.g. "filename.json"
     */
    @JvmStatic
    fun getStringFromAssets(fileName: String): String {
        CoreApplication.instance.assets.open(fileName).bufferedReader().use {
            return it.readText()
        }
    }

}