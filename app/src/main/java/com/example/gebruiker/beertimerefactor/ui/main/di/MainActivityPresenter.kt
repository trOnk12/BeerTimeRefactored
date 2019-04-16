package com.example.gebruiker.beertimerefactor.ui.main.di

import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.model.firebase.FirebaseRepo
import com.example.gebruiker.beertimerefactor.model.repository.UserRepository
import com.example.gebruiker.beertimerefactor.model.source.remote.UserRemoteSource
import com.google.firebase.database.DataSnapshot

class MainActivityPresenter(var userRepository: UserRepository)  : BasePresenter<MainActivityView>() {

    fun getUser() {
        getView().displayUser(userRepository.getUser()!!)
    }

}