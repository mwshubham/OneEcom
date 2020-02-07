package app.oneecom.launcher.di.modules

import android.content.Context
import app.oneecom.core.di.scopes.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class LauncherModule {

    @Provides
    @ActivityScope
    fun provideString(appContext: Context): String = this::class.java.simpleName
}