package com.example.gebruiker.beertimerefactor.model.repository

import android.util.Log
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.model.domain.IBaseRepository
import com.example.gebruiker.beertimerefactor.model.domain.IUserRepository
import com.example.gebruiker.beertimerefactor.model.source.local.UserCachedSource
import com.example.gebruiker.beertimerefactor.model.source.remote.BaseRemoteSource
import com.example.gebruiker.beertimerefactor.model.source.remote.UserRemoteSource
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.database.DataSnapshot
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.FirebaseAuthException
import com.google.gson.Gson

class UserRepository(val userCachedSource: UserCachedSource, val userRemoteSource: UserRemoteSource) : IUserRepository {


    override fun addUser(user: User) {
        userRemoteSource.addUser(user)
    }

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
        userRemoteSource.loginUser(email, password,object:UserRemoteSource.LoggedUserListener{
            override fun onLoggedUserListener(fireBaseUser: FirebaseUser) {
                val user = User()
                user.id=fireBaseUser.uid
                user.email=fireBaseUser.email

               userCachedSource.putData(user)

               onSuccessListener.onDataReceived(true)
            }
        })
    }

    override fun registerUser(email: String, password: String, onSuccessListener: IBaseRepository<Boolean>) {
        userRemoteSource.registerUser(email, password, OnCompleteListener { p0 ->
            if (!p0.isSuccessful) {
                val e = p0.exception as FirebaseAuthException
                Log.d("TEST",e.message)
                return@OnCompleteListener
            }

            if(p0.isSuccessful){

                onSuccessListener.onDataReceived(true)
            }
        })
    }

}