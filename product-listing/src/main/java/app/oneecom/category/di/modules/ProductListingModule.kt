package app.oneecom.category.di.modules

import androidx.lifecycle.ViewModel
import app.oneecom.category.ui.viewmodels.ProductListingViewModel
import app.oneecom.core.di.scopes.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProductListingModule {
    @Binds
    @IntoMap
    @ViewModelKey(ProductListingViewModel::class)
    internal abstract fun bindLauncherViewModel(viewModel: ProductListingViewModel): ViewModel
}