package app.oneecom.categories.di.modules

import androidx.lifecycle.ViewModel
import app.oneecom.categories.ui.CategoriesFragment
import app.oneecom.categories.ui.CategoriesViewModel
import app.oneecom.core.di.scopes.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class CategoriesModule {

    @ContributesAndroidInjector()
    abstract fun bindCategoriesFragment(): CategoriesFragment

    @Binds
    @IntoMap
    @ViewModelKey(CategoriesViewModel::class)
    internal abstract fun bindCategoriesViewModel(viewModel: CategoriesViewModel): ViewModel

}