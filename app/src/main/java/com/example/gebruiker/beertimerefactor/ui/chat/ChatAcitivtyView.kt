package com.example.gebruiker.beertimerefactor.ui.chat

import com.example.gebruiker.beertimerefactor.baseMVP.BaseView
import com.example.gebruiker.beertimerefactor.model.Message

interface ChatAcitivtyView : BaseView {
    fun displayChatHistory(messageList: ArrayList<Message>)
    fun displayNewMessage(message: Message)
}