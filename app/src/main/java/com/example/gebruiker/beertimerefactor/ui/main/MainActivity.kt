package com.example.gebruiker.beertimerefactor.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.ui.main.di.MainActivityPresenter
import com.example.gebruiker.beertimerefactor.ui.main.di.MainActivityView
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainActivityView {

    @Inject
    lateinit var mainActivityPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityPresenter.attachView(this)
        setContentView(R.layout.activity_main)

        mainActivityPresenter.getUserAndDisplay()

    }

    override fun displayUser(user: String?) {

    }

}
