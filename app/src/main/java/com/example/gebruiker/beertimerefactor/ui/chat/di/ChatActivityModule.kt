package com.example.gebruiker.beertimerefactor.ui.chat.di

import com.example.gebruiker.beertimerefactor.model.repo.FirebaseRepo
import com.example.gebruiker.beertimerefactor.ui.chat.ChatActivityPresenter
import dagger.Module
import dagger.Provides


@Module
class ChatActivityModule {

    @Provides
    fun provideChatPresenter(firebaseRepo: FirebaseRepo): ChatActivityPresenter {
        return ChatActivityPresenter(firebaseRepo)
    }

}