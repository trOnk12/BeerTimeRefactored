package com.example.gebruiker.beertimerefactor.model.repo

import com.basgeekball.awesomevalidation.AwesomeValidation
import com.example.gebruiker.beertimerefactor.model.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class UserRepository(var fireBaseRepo: FirebaseRepo, var sharedPreferencesRepository: SharedPreferencesRepository) {

    fun getUserCached(): User? {
        return sharedPreferencesRepository.getUser()
    }

    fun getUser(fireBaseRepoListener: FirebaseRepo.DataSnapShotListener) {
        val userCached = getUserCached()

        if (userCached != null) {
            fireBaseRepo.getUser(userCached.id, object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(p0: DataSnapshot) {
                    fireBaseRepoListener.onDatSnapShotReceived(p0)
                }
            })

        }

    }

    fun loginUser(email:String,password:String,listener:FireBaseAuthHelper.CallBackListener){
        fireBaseRepo.loginUser(email,password,listener)
    }

    fun register(email: String, password: String,listener:FireBaseAuthHelper.CallBackListener) {
        fireBaseRepo.registerUser(email,password,listener)
    }

}