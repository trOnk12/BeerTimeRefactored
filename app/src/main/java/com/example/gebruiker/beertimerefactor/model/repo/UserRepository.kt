package com.example.gebruiker.beertimerefactor.model.repo

import com.example.gebruiker.beertimerefactor.model.User

class UserRepository(var fireBaseRepo:FirebaseRepo,var sharedPreferencesRepository: SharedPreferencesRepository) {

    fun getUserCached(): User? {
        return sharedPreferencesRepository.getUser()
    }


}