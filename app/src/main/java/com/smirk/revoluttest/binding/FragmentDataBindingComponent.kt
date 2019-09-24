package com.smirk.revoluttest.binding

import androidx.databinding.DataBindingComponent
import androidx.fragment.app.Fragment

/**
 * Created by Tony Augustine on 09,September,2019
 * tonyaugustine47@gmail.com
 */
class FragmentDataBindingComponent(fragment: Fragment) : DataBindingComponent {
    override fun getFragmentBindingAdapters(): FragmentBindingAdapters {
        return adapter
    }

    private val adapter = FragmentBindingAdapters(fragment)


}