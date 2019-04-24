package com.example.gebruiker.beertimerefactor.ui.main.di

import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.repository.IUserRepository

class MainActivityPresenter(var userRepository: IUserRepository)  : BasePresenter<MainActivityView>() {

    fun getUser() {
        getView().displayUser(userRepository.getUser()!!)
    }

}