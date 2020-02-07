package app.oneecom.launcher.ui

import android.os.Bundle
import android.os.Handler
import app.oneecom.core.extentions.TAG
import app.oneecom.core.ui.CoreActivity
import app.oneecom.launcher.R
import app.oneecom.launcher.databinding.ActivityLauncherBinding
import app.oneecom.navigation.HomeActions

class LauncherActivity :
    CoreActivity<ActivityLauncherBinding, LauncherViewModel>(R.layout.activity_launcher) {

    override val logTAG: String
        get() = TAG

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        handler.postDelayed(
            {
                startActivity(HomeActions.openHomePageActivity(this))
            }, 3000
        )
    }
}

