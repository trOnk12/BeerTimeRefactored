package com.example.gebruiker.beertimerefactor.model.repository

import android.util.Log
import com.example.gebruiker.beertimerefactor.BaseCachedSource
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.model.domain.UserRepositoryContractor
import com.example.gebruiker.beertimerefactor.model.firebase.FireBaseAuthHelper
import com.example.gebruiker.beertimerefactor.model.firebase.FirebaseRepo
import com.example.gebruiker.beertimerefactor.model.source.local.UserCachedSource
import com.example.gebruiker.beertimerefactor.model.source.remote.BaseRemoteSource
import com.example.gebruiker.beertimerefactor.model.source.remote.UserRemoteSource
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class UserRepository(val userCachedSource: UserCachedSource, val userRemoteSource: UserRemoteSource) : UserRepositoryContractor {

    override fun getUser(): User? {
        return userCachedSource.getData()
    }

    override fun getUserById(id: String): User? {
        userRemoteSource.getUserById(id, object : BaseRemoteSource.DataSnapShotListener {

            override fun onDataSnapShotInterrupted() {

            }

            override fun onDatSnapShotReceived(dataSnapShot: DataSnapshot) {
                val user = dataSnapShot.getValue(User::class.java)
                userCachedSource.putData(user!!)
            }

        })
    }

    override fun loginUser(email: String, password: String) {

    }

    override fun registerUser(email: String, password: String) {

    }


}