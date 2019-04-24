package com.example.gebruiker.beertimerefactor.ui.splash

import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.repository.IUserRepository

class SplashActivityPresenter(var userRepository: IUserRepository): BasePresenter<SplashActivityView>() {

    fun getUser(){
        if(userRepository.getUser() == null){
            getView().launchLoginActivity()
        }
        else{
            getView().launchMainActivity()
        }
    }

}