package com.example.gebruiker.beertimerefactor.model

import android.content.Context
import com.google.firebase.auth.FirebaseUser
import android.R.id.edit
import android.content.SharedPreferences
import com.example.gebruiker.beertimerefactor.R


class SharedPreferencesRepository(var context: Context) {

    var userLoggedIn = false

    fun userLoggedIn(currentUser: FirebaseUser?) {
        val sharedPref = context.getSharedPreferences(  "com.example.MyApp",Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(context.getString(R.string.user_logged_id_key), currentUser!!.uid)
        editor.apply()

        userLoggedIn = true

    }

    fun userLogOut(){

    }

    fun isUserLoggedIn(): Boolean {
        return userLoggedIn
    }

}
