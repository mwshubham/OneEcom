package app.oneecom.di.modules

import app.oneecom.categories.di.modules.CartModule
import app.oneecom.categories.di.modules.CategoriesModule
import app.oneecom.categories.di.modules.ProfileModule
import app.oneecom.category.di.modules.ProductListingModule
import app.oneecom.category.ui.activities.ProductListingActivity
import app.oneecom.core.di.scopes.ActivityScope
import app.oneecom.home.di.modules.HomeModule
import app.oneecom.home.ui.activities.HomeActivity
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
            HomeModule::class,
            CategoriesModule::class,
            CartModule::class,
            ProfileModule::class
        ]
    )
    abstract fun bindHomePageActivity(): HomeActivity

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            ProductListingModule::class
        ]
    )
    abstract fun bindProductListingActivity(): ProductListingActivity
}
