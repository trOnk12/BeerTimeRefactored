package com.example.gebruiker.beertimerefactor.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.gebruiker.beertimerefactor.BaseActivity
import com.example.gebruiker.beertimerefactor.model.repo.SharedPreferencesRepository
import com.example.gebruiker.beertimerefactor.ui.login.LoginActivity
import com.example.gebruiker.beertimerefactor.ui.main.MainActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    @Inject
    lateinit var sharedPreferencesRepository: SharedPreferencesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        checkIfLogin()
        finish()
    }

    private fun checkIfLogin() {

        if(sharedPreferencesRepository.isUserLoggedIn())
            launchMainActivity()
        else{
            launchLoginActivity()
        }

    }

    private fun launchMainActivity() {
       startActivity(MainActivity.createMainActivity(this))
    }

    private fun launchLoginActivity() {
        startActivity(LoginActivity.createLoginActivity(this))
    }

}