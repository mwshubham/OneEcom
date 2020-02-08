package app.oneecom.home.di.modules

import androidx.lifecycle.ViewModel
import app.oneecom.core.di.scopes.ActivityScope
import app.oneecom.core.di.scopes.ViewModelKey
import app.oneecom.core.network.responses.CharacterDetailMapper
import app.oneecom.home.ui.HomeActivityViewModel
import app.oneecom.home.ui.cart.CartFragment
import app.oneecom.home.ui.cart.CartViewModel
import app.oneecom.home.ui.categories.CategoriesFragment
import app.oneecom.home.ui.categories.CategoriesViewModel
import app.oneecom.home.ui.home.HomeFragment
import app.oneecom.home.ui.profile.ProfileFragment
import app.oneecom.home.ui.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class HomeModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeActivityViewModel::class)
    internal abstract fun bindHomeActivityViewModel(viewModel: HomeActivityViewModel): ViewModel

    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector()
    abstract fun bindCategoriesFragment(): CategoriesFragment

    @Binds
    @IntoMap
    @ViewModelKey(CategoriesViewModel::class)
    internal abstract fun bindCategoriesViewModel(viewModel: CategoriesViewModel): ViewModel

    @ContributesAndroidInjector()
    abstract fun bindCartFragment(): CartFragment

    @Binds
    @IntoMap
    @ViewModelKey(CartViewModel::class)
    internal abstract fun bindCartViewModel(viewModel: CartViewModel): ViewModel

    @ContributesAndroidInjector()
    abstract fun bindProfileFragment(): ProfileFragment

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    internal abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel

    companion object {
        /**
         * Create a provider method binding for [CharacterDetailMapper].
         *
         * @return instance of mapper.
         * @see Provides
         */
        @Provides
        @ActivityScope
        fun providesCharacterDetailMapper() = CharacterDetailMapper()

    }

}