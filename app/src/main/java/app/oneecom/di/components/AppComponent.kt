/*
 * Copyright 2019 vmadalin.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.oneecom.di.components

import android.content.Context
import app.oneecom.OneEcomApp
import app.oneecom.core.di.modules.CoreModule
import app.oneecom.core.di.modules.DatabaseModule
import app.oneecom.core.di.modules.NetworkModule
import app.oneecom.di.modules.ActivityBuilderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * App component that application component's components depend on.
 *
 * @see Component
 */

// This annotation is used to build interface which wires everything together.
// In this place we define from which modules (or other Components) we’re taking dependencies.
// in general is a something like bridge between @Module and @Inject.
@Singleton
@Component(
    modules = [
        CoreModule::class,
        AndroidInjectionModule::class,
        ActivityBuilderModule::class,
        DatabaseModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<OneEcomApp> {
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance appContext: Context): AppComponent
    }

//    fun marvelService(): MarvelService

    // 2) Expose UserManager so that MainActivity and SettingsActivity
    // can access a particular instance of UserComponent
//    fun userManager(): UserManager

//    fun homeComponent(): HomeComponent.Factory
//    fun loginComponent(): LoginComponent.Factory
}