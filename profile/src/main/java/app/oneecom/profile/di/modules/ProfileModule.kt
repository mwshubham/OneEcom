package app.oneecom.categories.di.modules

import androidx.lifecycle.ViewModel
import app.oneecom.core.di.scopes.ViewModelKey
import app.oneecom.profile.ui.ProfileFragment
import app.oneecom.profile.ui.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ProfileModule {

    @ContributesAndroidInjector()
    abstract fun bindProfileFragment(): ProfileFragment

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    internal abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel

}