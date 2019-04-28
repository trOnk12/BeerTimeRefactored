package com.example.gebruiker.beertimerefactor.ui.main.di

import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.repository.UserRepository

class MainActivityPresenter(var userRepository: UserRepository)  : BasePresenter<MainActivityView>() {

    fun getUser() {
        getView().displayUser(userRepository.getUser()!!)
    }

    fun logout() {
        if(userRepository.logout()){
            getView().logoutSuccessful()
        }
        else{
            getView().logoutFailure()
        }
    }

}