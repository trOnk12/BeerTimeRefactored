package com.example.gebruiker.beertimerefactor.ui.register.di

import com.basgeekball.awesomevalidation.AwesomeValidation
import com.example.gebruiker.beertimerefactor.model.source.remote.UserRemoteSource
import com.example.gebruiker.beertimerefactor.ui.register.RegisterPresenter
import dagger.Module
import dagger.Provides

@Module
class RegisterModule {

    @Provides
    fun provideRegisterPresenter(userRemoteSource: UserRemoteSource, validation: AwesomeValidation) : RegisterPresenter{
        return RegisterPresenter(userRemoteSource,validation)
    }

}