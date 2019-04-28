package com.example.gebruiker.beertimerefactor.ui.login

import com.example.gebruiker.beertimerefactor.baseMVP.BaseView

interface LoginActivityView : BaseView {

    fun isLoading(isLoading: Boolean)
    fun loginSuccessFull()

}