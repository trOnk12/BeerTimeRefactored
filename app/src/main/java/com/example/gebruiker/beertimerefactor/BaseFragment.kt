package com.example.gebruiker.beertimerefactor

import android.os.Bundle
import dagger.android.support.DaggerFragment

abstract class BaseFragment:DaggerFragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initializeLayout()
    }

    abstract fun initializeLayout()

}