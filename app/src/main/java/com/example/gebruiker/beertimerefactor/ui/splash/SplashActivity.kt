package com.example.gebruiker.beertimerefactor.ui.splash

import android.os.Bundle
import com.example.gebruiker.beertimerefactor.BaseActivity
import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.baseMVP.BaseView
import com.example.gebruiker.beertimerefactor.ui.login.LoginActivity
import com.example.gebruiker.beertimerefactor.ui.main.MainActivity
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashActivityView {

    @Inject
    lateinit var splashActivityPresenter: SplashActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashActivityPresenter.attachView(this)

        splashActivityPresenter.getUser()
    }


    override fun launchMainActivity() {
        launchActivityWithFinish(MainActivity.createMainActivity(this))
    }

    override fun launchLoginActivity() {
        launchActivityWithFinish(LoginActivity.createLoginActivity(this))
    }

}