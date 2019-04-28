package com.example.gebruiker.beertimerefactor.ui.register

import com.example.gebruiker.beertimerefactor.baseMVP.BaseView

interface RegisterView : BaseView {

    fun registrationSuccessful()
    fun isLoading(isLoading: Boolean)

}