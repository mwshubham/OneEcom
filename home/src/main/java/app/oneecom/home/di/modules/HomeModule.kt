package app.oneecom.home.di.modules

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import app.oneecom.core.di.scopes.ActivityScope
import app.oneecom.core.di.scopes.ViewModelKey
import app.oneecom.core.network.responses.CharacterDetailMapper
import app.oneecom.home.HomeActivity
import app.oneecom.home.ui.home.HomeFragment
import app.oneecom.home.ui.home.HomeFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class HomeModule {

    @Binds
    abstract fun provideActivity(activity: HomeActivity): AppCompatActivity

    @ContributesAndroidInjector()
    abstract fun bindHomeFragment(): HomeFragment

    @Binds
    @IntoMap
    @ViewModelKey(HomeFragmentViewModel::class)
    internal abstract fun bindHomeFragmentViewModel(viewModel: HomeFragmentViewModel): ViewModel

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