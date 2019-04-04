package com.example.gebruiker.beertimerefactor.ui.splash.di

import com.example.gebruiker.beertimerefactor.model.repo.SharedPreferencesRepository
import com.example.gebruiker.beertimerefactor.model.repo.UserRepository
import com.example.gebruiker.beertimerefactor.ui.splash.SplashActivityPresenter
import dagger.Module
import dagger.Provides

@Module
class SplashActivityModule {

    @Provides
    fun provideSplashActivityPresenter(userRepository: UserRepository) : SplashActivityPresenter {
        return SplashActivityPresenter(userRepository)
    }
}