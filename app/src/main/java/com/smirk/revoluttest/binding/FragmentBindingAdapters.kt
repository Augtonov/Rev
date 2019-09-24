package com.smirk.revoluttest.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import javax.inject.Inject

/**
 * Created by Tony Augustine on 09,September,2019
 * tonyaugustine47@gmail.com
 */

class FragmentBindingAdapters @Inject constructor(val fragment : Fragment) {

    @BindingAdapter("imageUrl")
    fun bindImage(imageView: ImageView, url: String?) {
    }

}