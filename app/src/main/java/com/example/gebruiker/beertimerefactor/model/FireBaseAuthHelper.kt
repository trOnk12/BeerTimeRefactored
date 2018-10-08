package com.example.gebruiker.beertimerefactor.model

import android.content.Context
import android.content.SharedPreferences
import android.util.Patterns
import com.google.firebase.auth.FirebaseAuth
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.ui.login.LoginActivity
import com.example.gebruiker.beertimerefactor.ui.register.RegisterActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseUser
import android.widget.Toast
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.Task
import android.support.annotation.NonNull
import com.google.android.gms.tasks.OnCompleteListener
import android.R.attr.password
import android.util.Log


class FireBaseAuthHelper(var sharedPreferencesRepository : SharedPreferencesRepository) {

    interface CallBackListener {
        fun success()
        fun error()
    }

    private var fireBaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun registerUser(email: String, password: String, callBackListener: CallBackListener) {
        fireBaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
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