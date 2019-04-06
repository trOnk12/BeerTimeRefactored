package com.example.gebruiker.beertimerefactor.ui.chat.di

import com.example.gebruiker.beertimerefactor.model.firebase.FirebaseRepo
import com.example.gebruiker.beertimerefactor.model.repo.local.SharedPreferencesRepository
import com.example.gebruiker.beertimerefactor.ui.chat.ChatActivityPresenter
import dagger.Module
import dagger.Provides


@Module
class ChatActivityModule {

    @Provides
    fun provideChatPresenter(sharedPreferencesRepository: SharedPreferencesRepository, firebaseRepo: FirebaseRepo): ChatActivityPresenter {
        return ChatActivityPresenter(sharedPreferencesRepository,firebaseRepo)
    }

}