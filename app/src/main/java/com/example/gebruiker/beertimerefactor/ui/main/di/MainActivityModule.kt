package com.example.gebruiker.beertimerefactor.ui.main.di

import com.example.gebruiker.beertimerefactor.model.repo.remote.UserRepository
import dagger.Module
import dagger.Provides


@Module
class MainActivityModule {

    @Provides
    fun provideMainActivityPresenter(userRepository: UserRepository) : MainActivityPresenter{
        return MainActivityPresenter(userRepository)
    }
}