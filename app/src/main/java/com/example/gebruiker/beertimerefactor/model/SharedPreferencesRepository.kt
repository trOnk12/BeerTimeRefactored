package com.example.gebruiker.beertimerefactor.model

import android.content.Context
import com.google.firebase.auth.FirebaseUser
import android.R.id.edit
import android.content.SharedPreferences
import com.example.gebruiker.beertimerefactor.R


class SharedPreferencesRepository(var context: Context) {

    var userLoggedIn = false

    private val sharedPref = context.getSharedPreferences(  "com.example.MyApp",Context.MODE_PRIVATE)!!

    fun userLoggedIn(currentUser: FirebaseUser?) {

        val editor = sharedPref.edit()
        editor.putString(context.getString(R.string.user_logged_id_key), currentUser!!.uid)
        editor.apply()

        userLoggedIn = true

    }

    fun getUser(): String? {
        return sharedPref.getString(R.string.user_logged_id_key.toString(), "")
    }

    fun userLogOut(){

    }

    fun isUserLoggedIn(): Boolean {
        return userLoggedIn
    }

}
