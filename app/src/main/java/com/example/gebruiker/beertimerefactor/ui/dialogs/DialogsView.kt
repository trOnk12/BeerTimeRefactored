package com.example.gebruiker.beertimerefactor.ui.dialogs

import com.example.gebruiker.beertimerefactor.baseMVP.BaseView
import com.example.gebruiker.beertimerefactor.model.Dialog
import com.example.gebruiker.beertimerefactor.model.Message

interface DialogsView : BaseView {
    fun displayViews(list: ArrayList<Dialog>)
    fun openChatActivity(messageList: ArrayList<Message>)
}