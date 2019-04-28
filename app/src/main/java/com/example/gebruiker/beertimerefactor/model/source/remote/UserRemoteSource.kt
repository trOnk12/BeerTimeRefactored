package com.example.gebruiker.beertimerefactor.model.source.remote

import android.util.Log
import com.example.gebruiker.beertimerefactor.model.User
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class UserRemoteSource : BaseRemoteSource() {

    interface LoggedUserListener {
        fun onLoggedUserListener(fireBaseUser: FirebaseUser)
    }

    fun addUser(user: User) {
        fireBaseDataBase.getReference("users").child(user.id).setValue(user)
    }

    fun getUserById(id: String, listener: DataSnapShotListener) {

        fireBaseDataBase.getReference("users").child(id).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                listener.onDataSnapShotInterrupted()
            }

            override fun onDataChange(p0: DataSnapshot) {
                listener.onDatSnapShotReceived(p0)
            }

        })
    }

    fun loginUser(email: String, password: String, listener: LoggedUserListener) {
        fireBaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(OnCompleteListener<AuthResult> { p0 ->
            if (!p0.isSuccessful) {
                val e = p0.exception as FirebaseAuthException
                Log.d("TEST", e.message)
                return@OnCompleteListener
            }

            if (p0.isSuccessful) {
                listener.onLoggedUserListener(fireBaseAuth.currentUser!!)
            }
        })
    }


    fun registerUser(email: String, password: String, listener: OnCompleteListener<AuthResult>) {
        fireBaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(listener)
    }

}