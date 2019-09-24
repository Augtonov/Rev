package com.smirk.revoluttest.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Tony Augustine on 10,September,2019
 * tonyaugustine47@gmail.com
 */
@Entity
data class CRate(
    @PrimaryKey
    var currency : String,
    var value : String)