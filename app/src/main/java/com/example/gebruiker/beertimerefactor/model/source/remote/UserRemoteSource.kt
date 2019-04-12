package com.example.gebruiker.beertimerefactor.model.source.remote

import android.util.Log
import com.example.gebruiker.beertimerefactor.model.firebase.FireBaseAuthHelper
import com.example.gebruiker.beertimerefactor.model.firebase.FirebaseRepo
import com.example.gebruiker.beertimerefactor.model.source.local.UserCachedSource
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import io.reactivex.Observable


class UserRemoteSource : BaseRemoteSource() {
    fun getUserById(id:String,listener: DataSnapShotListener) {

        fireBaseDataBase.getReference("users").child(id).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                listener.onDataSnapShotInterrupted()
            }

            override fun onDataChange(p0: DataSnapshot) {
                listener.onDatSnapShotReceived(p0)
            }

        })
    }


    fun loginUser(email: String, password: String, listener: OnCompleteListener<AuthResult>) {
        fireBaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(listener)
    }


    fun registerUser(email: String, password: String, listener: OnCompleteListener<AuthResult>) {
        fireBaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(listener)
    }

}