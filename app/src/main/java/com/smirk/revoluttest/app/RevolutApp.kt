package com.smirk.revoluttest.app

import android.app.Activity
import android.app.Application
import com.smirk.revoluttest.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Tony Augustine on 09,September,2019
 * tonyaugustine47@gmail.com
 */
class RevolutApp: Application(), HasActivityInjector {
    override fun activityInjector(): AndroidInjector<Activity> {
        return androidInjector
    }

    @Inject
    lateinit var androidInjector :
            DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }


}