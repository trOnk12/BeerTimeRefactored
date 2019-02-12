package com.example.gebruiker.beertimerefactor.ui.main.di

import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.repo.SharedPreferencesRepository

class MainActivityPresenter(var sharedPreferencesRepository: SharedPreferencesRepository)  : BasePresenter<MainActivityView>() {

    fun getUserAndDisplay() {
      getView().displayUser(sharedPreferencesRepository.getUser()!!)
    }

}