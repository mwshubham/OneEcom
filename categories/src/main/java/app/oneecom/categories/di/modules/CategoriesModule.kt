package app.oneecom.categories.di.modules

import androidx.lifecycle.ViewModel
import app.oneecom.categories.ui.fragments.CategoriesFragment
import app.oneecom.categories.ui.viewmodels.CategoriesViewModel
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