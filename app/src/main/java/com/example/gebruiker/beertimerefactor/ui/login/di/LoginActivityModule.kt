package com.example.gebruiker.beertimerefactor.ui.login.di

import com.example.gebruiker.beertimerefactor.model.FireBaseAuthHelper
import com.example.gebruiker.beertimerefactor.ui.login.LoginActivity
import com.example.gebruiker.beertimerefactor.ui.login.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
class LoginActivityModule {

    @Provides
    fun providePresenter(loginActivity: LoginActivity, fireBaseAuthHelper: FireBaseAuthHelper) : LoginPresenter {
        return LoginPresenter(loginActivity, fireBaseAuthHelper)
    }

}