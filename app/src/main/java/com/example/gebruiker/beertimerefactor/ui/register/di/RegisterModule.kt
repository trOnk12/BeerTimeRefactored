package com.example.gebruiker.beertimerefactor.ui.register.di

import com.example.gebruiker.beertimerefactor.model.repo.FireBaseAuthHelper
import com.example.gebruiker.beertimerefactor.ui.register.RegisterPresenter
import dagger.Module
import dagger.Provides

@Module
class RegisterModule {

    @Provides
    fun provideRegisterPresenter(fireBaseAuthHelper: FireBaseAuthHelper) : RegisterPresenter{
        return RegisterPresenter(fireBaseAuthHelper)
    }

}