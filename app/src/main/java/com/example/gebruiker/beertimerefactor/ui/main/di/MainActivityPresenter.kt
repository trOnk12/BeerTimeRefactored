package com.example.gebruiker.beertimerefactor.ui.main.di

import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.model.firebase.FirebaseRepo
import com.example.gebruiker.beertimerefactor.model.repo.remote.UserRepository
import com.google.firebase.database.DataSnapshot

class MainActivityPresenter(var userRepository: UserRepository)  : BasePresenter<MainActivityView>() {

    fun getUserAndDisplay() {
       userRepository.getUser(object : FirebaseRepo.DataSnapShotListener  {
            override fun onDatSnapShotReceived(dataSnapShot: DataSnapshot) {
               val user = dataSnapShot.getValue(User::class.java)
                getView().displayUser(user!!)
            }

        })
    }

}