package app.oneecom.home.di.modules

import android.content.Context
import app.oneecom.core.di.scopes.ActivityScope
import app.oneecom.core.network.responses.CharacterDetailMapper
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    @ActivityScope
    fun provideString(appContext: Context): String = this::class.java.simpleName

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