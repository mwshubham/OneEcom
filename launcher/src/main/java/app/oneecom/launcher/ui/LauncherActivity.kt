package app.oneecom.launcher.ui

import android.content.Context
import android.os.Bundle
import android.os.Handler
import app.oneecom.core.extentions.TAG
import app.oneecom.core.ui.CoreActivity
import app.oneecom.launcher.R
import app.oneecom.launcher.databinding.ActivityLauncherBinding
import app.oneecom.navigation.HomeActions
import timber.log.Timber
import javax.inject.Inject

class LauncherActivity :
    CoreActivity<ActivityLauncherBinding, LauncherViewModel>(R.layout.activity_launcher) {

    override val logTAG: String
        get() = TAG

    private val handler = Handler()

    @Inject
    lateinit var str: String

    @Inject
    lateinit var appContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("str: $str@${str.hashCode()}")
        Timber.i("appContext: $appContext")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        handler.postDelayed(
            {
                startActivity(HomeActions.openHomePageActivity(this))
            }, 3000
        )
    }
}

