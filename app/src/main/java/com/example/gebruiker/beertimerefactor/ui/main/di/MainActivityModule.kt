package com.example.gebruiker.beertimerefactor.ui.main.di

import com.example.gebruiker.beertimerefactor.model.repo.SharedPreferencesRepository
import dagger.Module
import dagger.Provides


@Module
class MainActivityModule {

    @Provides
    fun provideMainActivityPresenter(sharedPreferencesRepository: SharedPreferencesRepository) : MainActivityPresenter{
        return MainActivityPresenter(sharedPreferencesRepository)
    }
}