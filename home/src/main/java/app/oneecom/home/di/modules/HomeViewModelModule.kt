package app.oneecom.home.di.modules

import androidx.lifecycle.ViewModel
import app.oneecom.core.di.scopes.ViewModelKey
import app.oneecom.home.ui.home.HomeFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeFragmentViewModel::class)
    internal abstract fun bindHomeFragmentViewModel(viewModel: HomeFragmentViewModel): ViewModel
}