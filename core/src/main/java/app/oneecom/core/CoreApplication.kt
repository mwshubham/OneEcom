package app.oneecom.core

import android.app.Application
import androidx.multidex.MultiDexApplication
import app.oneecom.core.logging.CoreDebugTree
import com.facebook.stetho.Stetho
import timber.log.Timber

@Suppress("unused")
open class CoreApplication : MultiDexApplication() {

    companion object {
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        initStetho()
        initTimber()
        registerActivityLifecycleCallbacks()
    }

    private fun initStetho() {
        Stetho.initializeWithDefaults(this)
        Stetho.initialize(
            Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build()
        )
    }

    /**
     * Initialize log library Timber only on debug build.
     */
    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(CoreDebugTree())
        }
    }

    private fun registerActivityLifecycleCallbacks() {
        registerActivityLifecycleCallbacks(CoreActivityLifecycleCallbacks())
    }

}