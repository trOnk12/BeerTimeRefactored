package com.example.gebruiker.beertimerefactor.model.source.remote

import android.util.Log
import com.example.gebruiker.beertimerefactor.model.User
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class UserRemoteSource : BaseRemoteSource() {

    interface UserAuthenticationListener {
        interface  UserLoginListener {
            fun onUserLoginListener(fireBaseUser:FirebaseUser)
        }

        interface  RegisterListener {
            fun onUserRegisterListener(fireBaseUser:FirebaseUser)
        }
    }

    fun addUser(user: User) {
        fireBaseDataBase.getReference("users").child(user.id).setValue(user)
    }


    fun getUserFriends(usersID:ArrayList<String>): ArrayList<User> {
        val friendsList: ArrayList<User> = ArrayList()

        for(userID in usersID){
            fireBaseDataBase.getReference("users").child(userID).addListenerForSingleValueEvent(object:ValueEventListener{
                override fun onDataChange(p0: DataSnapshot) {
                    val user = p0.getValue(User::class.java)
                    friendsList.add(user!!)
            }

                override fun onCancelled(p0: DatabaseError) {

                }

            })
        }

        return friendsList
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

    fun loginUser(email: String, password: String, authenticationListener: UserAuthenticationListener.UserLoginListener) {
        fireBaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                val e = task.exception as FirebaseAuthException
                Log.d("TEST", e.message)
            }
            if (task.isSuccessful) {
                authenticationListener.onUserLoginListener(fireBaseAuth.currentUser!!)
            }
        }
    }

    fun registerUser(email: String, password: String, listener: UserAuthenticationListener.RegisterListener) {
        fireBaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                val e = task.exception as FirebaseAuthException
                Log.d("TEST", e.message)
            }
            if (task.isSuccessful) {
                listener.onUserRegisterListener(fireBaseAuth.currentUser!!)
            }
        }
    }

}