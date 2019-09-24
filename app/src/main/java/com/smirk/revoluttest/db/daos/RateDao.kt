package com.smirk.revoluttest.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.smirk.revoluttest.model.CRate

/**
 * Created by Tony Augustine on 19,September,2019
 * tonyaugustine47@gmail.com
 */
@Dao
abstract class RateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg data : CRate)
}