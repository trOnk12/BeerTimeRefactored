package com.example.gebruiker.beertimerefactor.model.source.local

import com.example.gebruiker.beertimerefactor.model.datasource.local.IChatCachedSource
import com.example.gebruiker.beertimerefactor.util.SharedPreferencesManager

class ChatCachedSource(var sharedPreferencesManager: SharedPreferencesManager): IChatCachedSource {

    override fun getUsersChats() {
        sharedPreferencesManager.getData("chat")
    }


}