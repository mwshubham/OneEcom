package app.oneecom.di.modules

import app.oneecom.core.di.scopes.ActivityScope
import app.oneecom.home.HomeActivity
import app.oneecom.home.di.modules.HomeModule
import app.oneecom.launcher.di.modules.LauncherModule
import app.oneecom.launcher.ui.LauncherActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            LauncherModule::class
        ]
    )
    abstract fun bindLauncherActivity(): LauncherActivity

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            HomeModule::class
        ]
    )
    abstract fun bindHomePageActivity(): HomeActivity
}
