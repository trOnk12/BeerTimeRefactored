package com.example.gebruiker.beertimerefactor.ui.splash.di

import com.example.gebruiker.beertimerefactor.model.source.remote.UserRemoteSource
import com.example.gebruiker.beertimerefactor.ui.splash.SplashActivityPresenter
import dagger.Module
import dagger.Provides

@Module
class SplashActivityModule {

    @Provides
    fun provideSplashActivityPresenter(userRemoteSource: UserRemoteSource) : SplashActivityPresenter {
        return SplashActivityPresenter(userRemoteSource)
    }
}