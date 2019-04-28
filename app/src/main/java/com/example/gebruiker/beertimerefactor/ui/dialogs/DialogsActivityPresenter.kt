package com.example.gebruiker.beertimerefactor.ui.dialogs

import android.view.View
import com.example.gebruiker.beertimerefactor.R.id.dialogsList
import com.example.gebruiker.beertimerefactor.R.id.empty_inbox_message
import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.Dialog
import com.example.gebruiker.beertimerefactor.model.source.remote.DialogRepository
import kotlinx.android.synthetic.main.activity_messages.*

class DialogsActivityPresenter(var dialogsRepository: DialogRepository) : BasePresenter<DialogsView>() {

    fun getUsersDialogs() {
        val usersDialogs: ArrayList<Dialog>? = dialogsRepository.getUsersDialogs()

        if (usersDialogs != null) {
            if(usersDialogs.isNotEmpty()) {
               getView().displayDialogs(usersDialogs)
            } else{
                getView().emptyInboxMessage()
            }
        }

        getView().displayDialogs(dialogsRepository.getUsersDialogs())
    }

}