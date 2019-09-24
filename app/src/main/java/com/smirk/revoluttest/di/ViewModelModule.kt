package com.smirk.revoluttest.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.smirk.revoluttest.viewmodel.ViewModelFactory
import com.smirk.revoluttest.viewmodel.ViewModelRates
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by Tony Augustine on 09,September,2019
 * tonyaugustine47@gmail.com
 */
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelRates::class)
    abstract fun bindViewModelRate(viewModel : ViewModelRates) : ViewModel
}