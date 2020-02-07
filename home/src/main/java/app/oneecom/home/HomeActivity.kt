package app.oneecom.home

import android.content.Context
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import app.oneecom.core.extentions.TAG
import app.oneecom.core.ui.CoreActivity
import app.oneecom.home.databinding.ActivityHomeBinding
import app.oneecom.home.ui.HomeActivityViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import timber.log.Timber
import javax.inject.Inject

class HomeActivity :
    CoreActivity<ActivityHomeBinding, HomeActivityViewModel>(R.layout.activity_home) {

    @Inject
    lateinit var str: String

    @Inject
    lateinit var appContext: Context

    override val logTAG: String
        get() = TAG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("str: $str@${str.hashCode()}")
        Timber.i("appContext: $appContext")

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_categories,
                R.id.navigation_cart,
                R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

}
