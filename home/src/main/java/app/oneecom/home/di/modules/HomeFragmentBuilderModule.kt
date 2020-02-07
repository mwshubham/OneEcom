package app.oneecom.home.di.modules

import app.oneecom.home.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentBuilderModule {

    @ContributesAndroidInjector()
    abstract fun bindHomeFragment(): HomeFragment
}