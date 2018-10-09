package com.example.gebruiker.beertimerefactor.ui.main.di

import com.example.gebruiker.beertimerefactor.model.SharedPreferencesRepository
import com.example.gebruiker.beertimerefactor.ui.main.MainActivity
import dagger.Module
import dagger.Provides


@Module
class MainActivityModule {

    @Provides
    fun provideMainActivityPresenter(sharedPreferencesRepository: SharedPreferencesRepository) : MainActivityPresenter{
        return MainActivityPresenter(sharedPreferencesRepository)
    }
}