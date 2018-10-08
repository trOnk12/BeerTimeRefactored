package com.example.gebruiker.beertimerefactor.ui.main.di

import com.example.gebruiker.beertimerefactor.baseMVP.BaseView

interface MainActivityView : BaseView {

    fun displayUser(user: String?)
}