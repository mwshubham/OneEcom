package app.oneecom.categories.di.modules

import androidx.lifecycle.ViewModel
import app.oneecom.cart.ui.fragments.CartFragment
import app.oneecom.cart.ui.viewmodels.CartViewModel
import app.oneecom.core.di.scopes.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class CartModule {

    @ContributesAndroidInjector()
    abstract fun bindCartFragment(): CartFragment

    @Binds
    @IntoMap
    @ViewModelKey(CartViewModel::class)
    internal abstract fun bindCartViewModel(viewModel: CartViewModel): ViewModel

}