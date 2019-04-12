package com.example.gebruiker.beertimerefactor.ui.main.di

import com.example.gebruiker.beertimerefactor.model.source.remote.UserRemoteSource
import dagger.Module
import dagger.Provides


@Module
class MainActivityModule {

    @Provides
    fun provideMainActivityPresenter(userRemoteSource: UserRemoteSource) : MainActivityPresenter{
        return MainActivityPresenter(userRemoteSource)
    }
}