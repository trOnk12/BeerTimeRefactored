package com.example.gebruiker.beertimerefactor.ui.login.di

import com.basgeekball.awesomevalidation.AwesomeValidation
import com.example.gebruiker.beertimerefactor.model.source.remote.UserRemoteSource
import com.example.gebruiker.beertimerefactor.ui.login.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
class LoginActivityModule {

    @Provides
    fun providePresenter(userRemoteSource: UserRemoteSource, validationTool:AwesomeValidation) : LoginPresenter {
        return LoginPresenter(userRemoteSource,validationTool)
    }

}