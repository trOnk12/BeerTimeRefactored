package com.example.gebruiker.beertimerefactor.ui.dialogs

import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.source.remote.DialogRepository

class DialogsActivityPresenter(var dialogsRepository: DialogRepository) : BasePresenter<DialogsView>() {

    fun getUsersDialogs() {
        getView().displayDialogs(dialogsRepository.getUsersDialogs())
    }

}