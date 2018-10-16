package com.example.gebruiker.beertimerefactor.ui.main

import android.content.Intent
import android.os.Bundle
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.ui.CustomChatIcon
import com.example.gebruiker.beertimerefactor.ui.main.di.MainActivityPresenter
import com.example.gebruiker.beertimerefactor.ui.main.di.MainActivityView
import com.example.gebruiker.beertimerefactor.ui.messages.MessagesActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.custom_toolbar_.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainActivityView, CustomChatIcon.OnChatClickListener {

    @Inject
    lateinit var mainActivityPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpToolbar()

        mainActivityPresenter.attachView(this)
        mainActivityPresenter.getUserAndDisplay()

        custom_chat.setOnChatClickListener(this)

    }

    private fun setUpToolbar() {

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.setDisplayShowTitleEnabled(false)

    }

    override fun displayUser(user: String?) {
        android.util.Log.d("TEST","user is"  +user)
    }

    override fun onChatClick() {

        val intent = Intent(this, MessagesActivity::class.java)
        startActivity(intent)

    }

}
