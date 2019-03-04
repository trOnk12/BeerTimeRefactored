package com.example.gebruiker.beertimerefactor.ui.main.di

import com.example.gebruiker.beertimerefactor.baseMVP.BaseView
import com.example.gebruiker.beertimerefactor.model.User

interface MainActivityView : BaseView {

    fun displayUser(user: User)
}