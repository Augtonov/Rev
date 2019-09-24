package com.smirk.revoluttest.di

import com.smirk.revoluttest.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Tony Augustine on 09,September,2019
 * tonyaugustine47@gmail.com
 */
@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector(modules = [FragmentBuilderModules::class])
    abstract fun contributeMainActivity() : MainActivity
}