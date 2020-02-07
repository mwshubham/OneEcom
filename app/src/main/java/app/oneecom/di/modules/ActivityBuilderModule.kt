package app.oneecom.di.modules

import app.oneecom.core.di.scopes.ActivityScope
import app.oneecom.home.HomeActivity
import app.oneecom.home.di.modules.HomeFragmentBuilderModule
import app.oneecom.home.di.modules.HomeModule
import app.oneecom.home.di.modules.HomeViewModelModule
import app.oneecom.launcher.di.modules.LauncherModule
import app.oneecom.launcher.di.modules.LauncherViewModelModule
import app.oneecom.launcher.ui.LauncherActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            LauncherModule::class,
            LauncherViewModelModule::class
        ]
    )
    abstract fun bindLauncherActivity(): LauncherActivity

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            HomeModule::class,
            HomeFragmentBuilderModule::class,
            HomeViewModelModule::class
        ]
    )
    abstract fun bindHomePageActivity(): HomeActivity
}
