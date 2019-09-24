package com.smirk.revoluttest.api

import androidx.lifecycle.LiveData
import com.smirk.revoluttest.model.Rate
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Tony Augustine on 09,September,2019
 * tonyaugustine47@gmail.com
 */
interface ApiService {

    @GET("latest")
    fun getRates(@Query("base") base : String) : LiveData<ApiResponse<Rate>>

    @GET("latest")
    fun getAllRates(@Query("base") base : String) : Flowable<Rate>
}