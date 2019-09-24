package com.smirk.revoluttest.utils

import androidx.lifecycle.LiveData

/**
 * Created by Tony Augustine on 09,September,2019
 * tonyaugustine47@gmail.com
 */

/**
 * A LiveData class that has `null` value.
 */
class AbsentLiveData<T : Any?> private constructor() : LiveData<T>() {
    init {
        // use post instead of set since this can be created on any thread
        postValue(null)
    }

    companion object {
        fun <T> create(): LiveData<T> {
            return AbsentLiveData()
        }
    }
}