package app.oneecom.home.ui.activities

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import app.oneecom.core.extentions.TAG
import app.oneecom.core.ui.CoreActivity
import app.oneecom.home.R
import app.oneecom.home.databinding.ActivityHomeBinding
import app.oneecom.home.ui.viewmodels.HomeActivityViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity :
    CoreActivity<ActivityHomeBinding, HomeActivityViewModel>(R.layout.activity_home) {

    override val logTAG: String
        get() = TAG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
