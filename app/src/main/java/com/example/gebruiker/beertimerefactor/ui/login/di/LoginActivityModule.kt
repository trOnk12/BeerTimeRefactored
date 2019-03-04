package com.example.gebruiker.beertimerefactor.ui.login.di

import com.example.gebruiker.beertimerefactor.model.repo.FireBaseAuthHelper
import com.example.gebruiker.beertimerefactor.ui.login.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
class LoginActivityModule {

    @Provides
    fun providePresenter(fireBaseAuthHelper: FireBaseAuthHelper) : LoginPresenter {
        return LoginPresenter(fireBaseAuthHelper)
    }

}