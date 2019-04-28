package com.example.gebruiker.beertimerefactor.ui.dialogs

import com.example.gebruiker.beertimerefactor.baseMVP.BaseView
import com.example.gebruiker.beertimerefactor.model.Dialog
import com.example.gebruiker.beertimerefactor.model.Message

interface DialogsView : BaseView {
    fun displayDialogs(usersDialogs: ArrayList<Dialog>?)
    fun emptyInboxMessage()
}