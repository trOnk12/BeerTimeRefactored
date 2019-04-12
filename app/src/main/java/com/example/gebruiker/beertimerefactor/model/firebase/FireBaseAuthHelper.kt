package com.example.gebruiker.beertimerefactor.model.firebase

import com.google.firebase.auth.FirebaseAuth
import android.util.Log
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.model.source.local.UserCachedSource
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener


class FireBaseAuthHelper(var fireBaseRepo: FirebaseRepo, var userCachedSource: UserCachedSource) {

    interface CallBackListener {
        fun success()
        fun error()
    }

    private var fireBaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun registerUser(email: String, password: String, callBackListener: CallBackListener) {
        fireBaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = fireBaseAuth.currentUser

                        if (user != null) {
                            val userShared = User()
                            userShared.id = user.uid
                            userShared.avatar = "null"
                            userShared.name = "trOnk12"
                            userShared.dialogs = arrayListOf("-LPQs6HSEb1o8vQzY0-w","-LPQre2Qxddw5VWm-PAi","-LPQs9TfbKOO6bh7Y4an")
                            fireBaseRepo.addUser(userShared)
                        }

                        callBackListener.success()
                    } else {
                        Log.d("TEST", "error" + task.exception)
                        callBackListener.error()
                    }
                }
    }


    fun loginUser(email: String, password: String, callback: CallBackListener) {

        fireBaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {

                fireBaseRepo.getUser(fireBaseAuth.currentUser!!.uid,object:ValueEventListener{

                    override fun onCancelled(p0: DatabaseError) {
                        callback.error()
                    }

                    override fun onDataChange(p0: DataSnapshot) {
                        val user = p0.getValue(User::class.java)
                        userCachedSource.putUser(user!!)

                        callback.success()
                    }

                })


            } else {
                callback.error()
            }
        }
    }

}