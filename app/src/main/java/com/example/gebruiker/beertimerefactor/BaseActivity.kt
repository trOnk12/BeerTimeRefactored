package com.example.gebruiker.beertimerefactor

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.baseMVP.BaseView
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity(),BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        attachPresenter()
    }

    fun showToast(mMessage: String) {
        Toast.makeText(this, mMessage, Toast.LENGTH_SHORT).show()
    }

    fun launchActivityWithFinish(intent: Intent){
        startActivity(intent)
        finish()
    }

    abstract fun attachPresenter()

}