package com.smirk.revoluttest.ui

import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import com.smirk.revoluttest.R
import com.smirk.revoluttest.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(this, R.id.navHostFragment).navigateUp()
    }
}
