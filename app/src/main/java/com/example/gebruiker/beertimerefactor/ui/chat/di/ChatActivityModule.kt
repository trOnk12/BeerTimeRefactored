package com.example.gebruiker.beertimerefactor.ui.chat.di

import com.example.gebruiker.beertimerefactor.model.firebase.FirebaseRepo
import com.example.gebruiker.beertimerefactor.model.source.local.UserCachedSource
import com.example.gebruiker.beertimerefactor.ui.chat.ChatActivityPresenter
import dagger.Module
import dagger.Provides


@Module
class ChatActivityModule {

    @Provides
    fun provideChatPresenter(userCachedSource: UserCachedSource, firebaseRepo: FirebaseRepo): ChatActivityPresenter {
        return ChatActivityPresenter(userCachedSource,firebaseRepo)
    }

}