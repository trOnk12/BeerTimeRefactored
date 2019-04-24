package com.example.gebruiker.beertimerefactor.model.repository

import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.model.domain.IBaseRepository
import com.example.gebruiker.beertimerefactor.model.domain.IUserRepository
import com.example.gebruiker.beertimerefactor.model.source.local.UserCachedSource
import com.example.gebruiker.beertimerefactor.model.source.remote.BaseRemoteSource
import com.example.gebruiker.beertimerefactor.model.source.remote.UserRemoteSource
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot

class IUserRepository(val userCachedSource: UserCachedSource, val userRemoteSource: UserRemoteSource) : IUserRepository {

    override fun getUser(): User? {
        return userCachedSource.getData()
    }

    override fun getUserById(id: String, dataListener: IBaseRepository<User>) {
        userRemoteSource.getUserById(id, object : BaseRemoteSource.DataSnapShotListener {

            override fun onDataSnapShotInterrupted() {

            }

            override fun onDatSnapShotReceived(dataSnapShot: DataSnapshot) {
                val user = dataSnapShot.getValue(User::class.java)
                dataListener.onDataReceived(user!!)
            }
        })
    }

    override fun loginUser(email: String, password: String, onSuccessListener: IBaseRepository<Boolean>) {
        userRemoteSource.loginUser(email, password, OnCompleteListener { onSuccessListener.onDataReceived(true) })
    }

    override fun registerUser(email: String, password: String, onSuccessListener: IBaseRepository<Boolean>) {
        userRemoteSource.registerUser(email, password, OnCompleteListener { onSuccessListener.onDataReceived(true) })
    }

}