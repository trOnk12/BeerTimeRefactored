package com.example.gebruiker.beertimerefactor.ui.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.gebruiker.beertimerefactor.BaseActivity
import com.example.gebruiker.beertimerefactor.model.repo.SharedPreferencesRepository
import com.example.gebruiker.beertimerefactor.ui.login.LoginActivity
import com.example.gebruiker.beertimerefactor.ui.main.MainActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashActivityView {

    @Inject
    lateinit var splashActivityPresenter: SplashActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splashActivityPresenter.attachView(this)

        splashActivityPresenter.getUserFromCache()
        finish()
    }


    override fun showLoginActivity() {
        launchLoginActivity()
    }

    override fun showMainActivity() {
        launchMainActivity()
    }


    private fun launchMainActivity() {
        startActivity(MainActivity.createMainActivity(this))
    }

    private fun launchLoginActivity() {
        startActivity(LoginActivity.createLoginActivity(this))
    }

}