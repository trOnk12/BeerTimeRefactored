package com.example.gebruiker.beertimerefactor.model.repository

import android.util.Log
import com.example.gebruiker.beertimerefactor.BaseCachedSource
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.model.domain.BaseRepositoryContractor
import com.example.gebruiker.beertimerefactor.model.domain.UserRepositoryContractor
import com.example.gebruiker.beertimerefactor.model.firebase.FireBaseAuthHelper
import com.example.gebruiker.beertimerefactor.model.firebase.FirebaseRepo
import com.example.gebruiker.beertimerefactor.model.source.local.UserCachedSource
import com.example.gebruiker.beertimerefactor.model.source.remote.BaseRemoteSource
import com.example.gebruiker.beertimerefactor.model.source.remote.UserRemoteSource
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class UserRepository(val userCachedSource: UserCachedSource, val userRemoteSource: UserRemoteSource) : UserRepositoryContractor {

    override fun getUser(): User? {
        return userCachedSource.getData()
    }

    override fun getUserById(id: String, dataListener: BaseRepositoryContractor<User>) {
        userRemoteSource.getUserById(id, object : BaseRemoteSource.DataSnapShotListener {

            override fun onDataSnapShotInterrupted() {

            }

            override fun onDatSnapShotReceived(dataSnapShot: DataSnapshot) {
                val user = dataSnapShot.getValue(User::class.java)
                dataListener.onDataReceived(user!!)
            }
        })
    }

    override fun loginUser(email: String, password: String, onSuccessListener: BaseRepositoryContractor<Boolean>) {
        userRemoteSource.loginUser(email, password, OnCompleteListener { onSuccessListener.onDataReceived(true) })
    }

    override fun registerUser(email: String, password: String, onSuccessListener: BaseRepositoryContractor<Boolean>) {
        userRemoteSource.registerUser(email, password, OnCompleteListener { onSuccessListener.onDataReceived(true) })
    }

}