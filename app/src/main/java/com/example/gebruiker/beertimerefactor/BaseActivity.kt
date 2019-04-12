package com.example.gebruiker.beertimerefactor

import android.content.Intent
import android.widget.Toast
import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    fun showToast(mMessage: String) {
        Toast.makeText(this, mMessage, Toast.LENGTH_SHORT).show()
    }

    fun launchActivityWithFinish(intent: Intent){
        launchActivityWithFinish(intent)
        finish()
    }

}