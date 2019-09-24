package com.smirk.revoluttest.di

import com.smirk.revoluttest.ui.RateListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Tony Augustine on 10,September,2019
 * tonyaugustine47@gmail.com
 */
@Module
abstract class FragmentBuilderModules {

    @ContributesAndroidInjector
    abstract fun contributeRateFragment() : RateListFragment
}