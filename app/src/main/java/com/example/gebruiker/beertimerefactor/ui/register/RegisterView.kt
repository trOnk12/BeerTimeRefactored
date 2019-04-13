package com.example.gebruiker.beertimerefactor.ui.register

import com.example.gebruiker.beertimerefactor.baseMVP.BaseView

interface RegisterView : BaseView {

    fun registerSuccessFullMessage()
    fun registerFailureMessage()
    fun launchLoginActivity()

}