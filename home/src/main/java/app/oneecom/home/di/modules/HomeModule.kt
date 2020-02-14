package app.oneecom.home.di.modules

import androidx.lifecycle.ViewModel
import app.oneecom.core.di.scopes.ViewModelKey
import app.oneecom.home.ui.fragments.HomeFragment
import app.oneecom.home.ui.viewmodels.HomeActivityViewModel
import dagger.Binds
import dagger.Module
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

//    companion object {
//        /**
//         * Create a provider method binding for [CharacterDetailMapper].
//         *
//         * @return instance of mapper.
//         * @see Provides
//         */
//        @Provides
//        @ActivityScope
//        fun providesCharacterDetailMapper() = CharacterDetailMapper()
//
//    }

}