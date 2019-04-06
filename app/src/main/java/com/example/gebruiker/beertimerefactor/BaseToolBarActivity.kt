package com.example.gebruiker.beertimerefactor

import android.os.Bundle
import android.widget.Toast
import dagger.android.support.DaggerAppCompatActivity

open class BaseToolBarActivity: DaggerAppCompatActivity() {

    override fun onStart() {
        super.onStart()
        setUpToolbar()
    }

    private fun setUpToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }


    fun showToast(mMessage: String) {
        Toast.makeText(this, mMessage, Toast.LENGTH_SHORT).show()
    }

}
