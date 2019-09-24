package com.smirk.revoluttest.di

import android.app.Application
import androidx.room.Room
import com.smirk.revoluttest.db.AppDataBase
import com.smirk.revoluttest.db.daos.RateDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Tony Augustine on 19,September,2019
 * tonyaugustine47@gmail.com
 */
@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideAppDataBase(context: Application): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "revolut_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideRateDao(appDataBase: AppDataBase): RateDao {
        return appDataBase.rateDao()
    }

}