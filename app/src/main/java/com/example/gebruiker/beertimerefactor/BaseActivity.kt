package com.example.gebruiker.beertimerefactor

import android.os.Bundle
import android.widget.Toast
import com.example.gebruiker.beertimerefactor.baseMVP.BaseView
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    fun showToast(mMessage: String) {
        Toast.makeText(this, mMessage, Toast.LENGTH_SHORT).show()
    }


}