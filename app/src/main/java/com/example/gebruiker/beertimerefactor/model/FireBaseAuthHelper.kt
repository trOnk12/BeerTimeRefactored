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


class FireBaseAuthHelper(var context: Context) {

    init {
        FirebaseApp.initializeApp(context)
    }

    interface CallBackListener {
        fun success()
        fun error()
    }


    private var fireBaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    var mAwesomeValidation = AwesomeValidation(ValidationStyle.BASIC)

    private val regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}"

    fun registerUser(registerActivity: RegisterActivity, email: String, password: String, callBackListener: CallBackListener) {

        fireBaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(registerActivity) { task ->
                    if (task.isSuccessful) {
                        saveUserToSharedPreferences(registerActivity.getSharedPreferences(
                                "com.example.MyApp", Context.MODE_PRIVATE), fireBaseAuth.currentUser)

                        callBackListener.success()
                    } else {
                        Log.d("TEST", "error" + task.exception )
                        callBackListener.error()
                    }
                }
    }

    fun loginUser(loginActivity: LoginActivity, email: String, password: String, callback: CallBackListener) {

        fireBaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                saveUserToSharedPreferences(loginActivity.getSharedPreferences(
                        "com.example.MyApp", Context.MODE_PRIVATE), fireBaseAuth.currentUser)

                callback.success()
            } else {
                callback.error()
            }
        }
    }

    fun validateLogin(loginActivity: LoginActivity): Boolean {

        mAwesomeValidation.addValidation(loginActivity, R.id.nickname_input, Patterns.EMAIL_ADDRESS, R.string.err_email)
        mAwesomeValidation.addValidation(loginActivity, R.id.password_input, regexPassword, R.string.err_password)

        return mAwesomeValidation.validate()
    }

    fun validateRegister(registerActivity: RegisterActivity): Boolean {

        mAwesomeValidation.addValidation(registerActivity, R.id.email_et, Patterns.EMAIL_ADDRESS, R.string.err_email)
        mAwesomeValidation.addValidation(registerActivity, R.id.password_et, regexPassword, R.string.err_password)
        mAwesomeValidation.addValidation(registerActivity, R.id.password_et, R.id.repeat_password_et, R.string.err_password_confirmation);

        return mAwesomeValidation.validate()
    }

    private fun saveUserToSharedPreferences(sharedPreferences: SharedPreferences, user: FirebaseUser?) {
        sharedPreferences.edit().putString(user!!.displayName, user.uid).apply()
    }

}