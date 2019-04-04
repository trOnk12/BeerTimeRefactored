package com.example.gebruiker.beertimerefactor.model.repo

import com.example.gebruiker.beertimerefactor.model.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class UserRepository(var fireBaseRepo:FirebaseRepo,var sharedPreferencesRepository: SharedPreferencesRepository) {

    fun getUserCached(): User? {
        return sharedPreferencesRepository.getUser()
    }

    fun getUser(): User? {
        val userCached=getUserCached()
        var user : User? = null

        if(userCached!=null){
            fireBaseRepo.getUser(userCached.id,object :ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(p0: DataSnapshot) {
                     user = p0.getValue(User::class.java)
                }
            })

        }

        return user
    }

}