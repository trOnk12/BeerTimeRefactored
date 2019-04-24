package com.example.gebruiker.beertimerefactor.model.repository

import com.example.gebruiker.beertimerefactor.model.source.local.ChatCachedSource
import com.example.gebruiker.beertimerefactor.model.source.remote.ChatRemoteSource

class ChatRepository(val chatCahcedSource: ChatCachedSource, val chatRemoteSource: ChatRemoteSource) {

    fun getUsersChats(){
        chatCahcedSource
    }

}