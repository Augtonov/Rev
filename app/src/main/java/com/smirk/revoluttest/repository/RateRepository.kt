package com.smirk.revoluttest.repository

import androidx.lifecycle.LiveData
import com.smirk.revoluttest.AppExecutors
import com.smirk.revoluttest.api.ApiResponse
import com.smirk.revoluttest.api.ApiService
import com.smirk.revoluttest.api.ApiSuccessResponse
import com.smirk.revoluttest.model.CRate
import com.smirk.revoluttest.model.Rate
import com.smirk.revoluttest.vo.Resource
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.intellij.lang.annotations.Flow
import javax.inject.Inject

/**
 * Created by Tony Augustine on 10,September,2019
 * tonyaugustine47@gmail.com
 */
class RateRepository @Inject constructor(
    private val appExecutors: AppExecutors,
    private val apiService: ApiService
) {

    fun getRates(base : String) : LiveData<Resource<Rate>> {

        return object : NetworkBoundResourceNoCache<Rate>(appExecutors) {
            override fun createCall(): LiveData<ApiResponse<Rate>> {
                return apiService.getRates(base)
            }

            override fun processResponse(response: ApiSuccessResponse<Rate>): Rate {
                val rate = response.body
                val list = ArrayList<CRate>()
                rate.rates?.forEach {
                    val cRate = CRate(it.key, it.value)
                    list.add(cRate)
                }
                rate.convertedRates = list
                return rate
            }

        }.asLiveData()
    }

    fun getAllRates(base : String) : Flowable<Rate> {
        return  apiService.getAllRates(base)
            .subscribeOn(Schedulers.io())
    }

}