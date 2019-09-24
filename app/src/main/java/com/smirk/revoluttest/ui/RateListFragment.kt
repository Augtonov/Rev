package com.smirk.revoluttest.ui


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.SimpleItemAnimator

import com.smirk.revoluttest.R
import com.smirk.revoluttest.base.BaseFragment
import com.smirk.revoluttest.databinding.FragmentRateListBinding
import com.smirk.revoluttest.utils.autoCleared
import com.smirk.revoluttest.viewmodel.ViewModelRates
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class RateListFragment : BaseFragment<FragmentRateListBinding>() {

    private lateinit var mViewModel : ViewModelRates
    private var adapter by autoCleared<AdapterRates>()

    override fun getLayoutId(): Int {
        return  R.layout.fragment_rate_list
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.let {
            mViewModel = getViewModelShared(it, ViewModelRates::class.java)
        }
        mBinding.rateList.isNestedScrollingEnabled = false
        adapter = AdapterRates()
        mBinding.rateList.adapter = adapter
        (mBinding.rateList.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false

        observeData()

        /*mBinding.nestedScrollView.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                when(p1?.action) {
                    MotionEvent.ACTION_SCROLL -> {

                    }

                    MotionEvent.ACTION_DOWN -> {

                    }

                }
            }

        })

        mBinding.nestedScrollView.setOnScrollChangeListener(object : NestedScrollView.OnScrollChangeListener {
            override fun onScrollChange(
                v: NestedScrollView?,
                scrollX: Int,
                scrollY: Int,
                oldScrollX: Int,
                oldScrollY: Int
            ) {



                if (scrollY > oldScrollY) {
                    Log.d("QWE", "Scrolling")
                }else if(scrollY < oldScrollY) {
                    Log.d("QWE", "Scrolling")
                }else {
                    Log.d("QWE", "Stop Scrolling")
                }

            }


        })*/


    }

    private fun observeData() {
        /*mViewModel.getCurrencyList.observe(this, Observer {response ->
            if (response.data == null)
                return@Observer

        })*/

        mViewModel.currencyList.observe(this, Observer {data ->
            if (data == null)
                return@Observer

            data.convertedRates?.let { adapter.setData(it) }
//            Timber.e(data.toString(), "")
        })
    }

    override fun onResume() {
        super.onResume()
        mViewModel.getRates("GBP")
    }

    override fun onPause() {
        super.onPause()
        mViewModel.stopPolling()
    }
}
