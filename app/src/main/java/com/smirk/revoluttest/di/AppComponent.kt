package com.smirk.revoluttest.di

import android.app.Application
import com.smirk.revoluttest.app.RevolutApp
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Tony Augustine on 09,September,2019
 * tonyaugustine47@gmail.com
 */
@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun build() : AppComponent

        @BindsInstance
        fun app(app: Application) : Builder
    }

    fun inject(app: RevolutApp)
}