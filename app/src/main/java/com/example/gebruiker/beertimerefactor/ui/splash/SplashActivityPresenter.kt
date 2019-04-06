package com.example.gebruiker.beertimerefactor.ui.splash

import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.repo.remote.UserRepository

class SplashActivityPresenter(var userRepository: UserRepository): BasePresenter<SplashActivityView>() {

    fun getUserFromCache(){
        if(userRepository.getUserCached() == null){
            getView().showLoginActivity()
        }
        else{
            getView().showMainActivity()
        }
    }

}