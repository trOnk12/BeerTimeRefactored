package com.example.gebruiker.beertimerefactor.ui.main.di

import android.util.Log
import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.repo.SharedPreferencesRepository
import com.example.gebruiker.beertimerefactor.model.repo.UserRepository

class MainActivityPresenter(var userRepository: UserRepository)  : BasePresenter<MainActivityView>() {

    fun getUserAndDisplay() {
        val user = userRepository.getUser()

        if(user!=null){
            getView().displayUser(user)
        }
        else{
           throw Exception("No user existing")
        }
    }

}