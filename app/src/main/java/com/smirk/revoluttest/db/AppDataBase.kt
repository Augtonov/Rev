package com.smirk.revoluttest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.smirk.revoluttest.db.daos.RateDao
import com.smirk.revoluttest.model.CRate

/**
 * Created by Tony Augustine on 19,September,2019
 * tonyaugustine47@gmail.com
 */
@Database(entities = [CRate::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun rateDao() : RateDao
}