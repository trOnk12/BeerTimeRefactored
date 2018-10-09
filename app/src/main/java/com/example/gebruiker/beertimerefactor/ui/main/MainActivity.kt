package com.example.gebruiker.beertimerefactor.ui.main

import android.os.Bundle
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.ui.main.di.MainActivityPresenter
import com.example.gebruiker.beertimerefactor.ui.main.di.MainActivityView
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainActivityView {

    @Inject
    lateinit var mainActivityPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        mainActivityPresenter.attachView(this)
        mainActivityPresenter.getUserAndDisplay()
    }

    override fun displayUser(user: String?) {

    }

}
