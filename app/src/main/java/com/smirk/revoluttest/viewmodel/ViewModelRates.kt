package com.smirk.revoluttest.viewmodel

import androidx.lifecycle.*
import com.smirk.revoluttest.model.CRate
import com.smirk.revoluttest.model.Rate
import com.smirk.revoluttest.repository.RateRepository
import com.smirk.revoluttest.utils.AbsentLiveData
import com.smirk.revoluttest.vo.Resource
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Tony Augustine on 10,September,2019
 * tonyaugustine47@gmail.com
 */
class ViewModelRates @Inject constructor(
    private val repo : RateRepository) : ViewModel(){

    private val currency = MutableLiveData<String>()
    val currencyList = MutableLiveData<Rate>()

    private var disposible = CompositeDisposable()

    fun changeCurrecny(cur : String) {
        currency.value = cur
    }

    val getCurrencyList : LiveData<Resource<Rate>> = Transformations.switchMap(currency) {
        if (it == null) {
            AbsentLiveData.create()
        }else {
            repo.getRates(it)
        }
    }

    fun getRates(base : String) = disposible.add(Flowable.interval(0,1, TimeUnit.SECONDS)
        .flatMap {
            repo.getAllRates(base)

        }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            processRates(it)

        }, {
            Timber.e(it)
        }))


    fun processRates(rate : Rate) {
        val list = ArrayList<CRate>()
        rate.rates?.forEach {
            val cRate = CRate(it.key, it.value)
            list.add(cRate)
        }
        rate.convertedRates = list
        currencyList.value = rate
    }

    fun stopPolling() {
        disposible.clear()
    }

}