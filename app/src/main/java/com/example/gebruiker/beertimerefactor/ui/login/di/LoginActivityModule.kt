package com.example.gebruiker.beertimerefactor.ui.login.di

import com.basgeekball.awesomevalidation.AwesomeValidation
import com.example.gebruiker.beertimerefactor.model.repo.FireBaseAuthHelper
import com.example.gebruiker.beertimerefactor.model.repo.UserRepository
import com.example.gebruiker.beertimerefactor.ui.login.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
class LoginActivityModule {

    @Provides
    fun providePresenter(userRepository: UserRepository,validationTool:AwesomeValidation) : LoginPresenter {
        return LoginPresenter(userRepository,validationTool)
    }

}