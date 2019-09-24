package com.smirk.revoluttest.di

import dagger.Module

/**
 * Created by Tony Augustine on 09,September,2019
 * tonyaugustine47@gmail.com
 */
@Module(includes = [RetrofitModule::class, PicassoModule::class,
    ViewModelModule::class, ActivitiesModule::class, RoomModule::class])
class AppModule {

}