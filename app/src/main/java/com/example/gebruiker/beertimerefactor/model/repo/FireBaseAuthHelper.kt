package com.example.gebruiker.beertimerefactor.model.repo

import com.google.firebase.auth.FirebaseAuth
import android.util.Log
import com.example.gebruiker.beertimerefactor.model.User


class FireBaseAuthHelper(var fireBaseRepo: FirebaseRepo, var sharedPreferencesRepository: SharedPreferencesRepository) {

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
                            fireBaseRepo.addUser(User("null", user.email.toString(), user.uid))
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
                sharedPreferencesRepository.userLoggedIn(fireBaseAuth.currentUser)
                callback.success()
            } else {
                callback.error()
            }
        }
    }

}