package com.worker8.simplecurrency.di

import com.worker8.simplecurrency.SimpleCurrencyApplication
import com.worker8.simplecurrency.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityModule::class
])
interface AppComponent : AndroidInjector<SimpleCurrencyApplication> {

    @Component.Builder
    abstract class Builder {
        @BindsInstance
        abstract fun application(application: SimpleCurrencyApplication): Builder

        abstract fun build(): AppComponent
    }
}