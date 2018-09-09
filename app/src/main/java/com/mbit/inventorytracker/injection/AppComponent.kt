package com.mbit.inventorytracker.injection

import com.mbit.inventorytracker.InitApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ActivityInjectorsModule::class,
        FragmentInjectorsModule::class))
interface AppComponent : AndroidInjector<InitApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<InitApp>() {
        abstract fun setApplicationModule(module: ApplicationModule)
    }

}