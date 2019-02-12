package com.example.gebruiker.beertimerefactor.model.repo

import android.content.Context
import com.google.firebase.auth.FirebaseUser
import android.R.id.edit
import android.content.SharedPreferences
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.model.User
import com.google.gson.Gson


class SharedPreferencesRepository(var context: Context) {

    var userLoggedIn = false

    private val sharedPref = context.getSharedPreferences(  "com.example.MyApp",Context.MODE_PRIVATE)!!

    fun userLoggedIn(user : User) {

        val editor = sharedPref.edit()

        val gson = Gson()
        val json = gson.toJson(user) // myObject - instance of MyObject
        editor.putString(context.getString(R.string.user_logged_id_key), json)
        editor.apply()

        userLoggedIn = true

    }

    fun getUser(): User? {

        val gson = Gson()
        val json = sharedPref.getString(context.getString(R.string.user_logged_id_key), "")
        val obj = gson.fromJson<User>(json, User::class.java)

        return obj
    }

    fun userLogOut(){

    }

    fun isUserLoggedIn(): Boolean {
        return userLoggedIn
    }

}
