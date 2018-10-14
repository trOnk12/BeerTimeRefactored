package com.example.gebruiker.beertimerefactor.ui.register

import com.example.gebruiker.beertimerefactor.baseMVP.BaseView

interface RegisterView : BaseView {

    fun registerSuccessFull()
    fun registerFailure()

}