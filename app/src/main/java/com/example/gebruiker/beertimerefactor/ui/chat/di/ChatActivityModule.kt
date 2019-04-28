package com.example.gebruiker.beertimerefactor.ui.chat.di

import com.example.gebruiker.beertimerefactor.model.firebase.FirebaseRepo
import com.example.gebruiker.beertimerefactor.model.repository.ChatRepository
import com.example.gebruiker.beertimerefactor.model.repository.UserRepository
import com.example.gebruiker.beertimerefactor.model.source.local.UserCachedSource
import com.example.gebruiker.beertimerefactor.ui.chat.ChatActivityPresenter
import dagger.Module
import dagger.Provides


@Module
class ChatActivityModule {

    @Provides
    fun provideChatPresenter(userRepository: UserRepository, chatRepository: ChatRepository): ChatActivityPresenter {
        return ChatActivityPresenter(userRepository,chatRepository)
    }

}