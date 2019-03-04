package com.example.gebruiker.beertimerefactor.model.repo

import android.content.Context
import com.google.firebase.auth.FirebaseUser
import android.R.id.edit
import android.content.SharedPreferences
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.model.User
import com.google.gson.Gson
import javax.inject.Singleton

@Singleton
class SharedPreferencesRepository(var context: Context) {

    private val sharedPref = context.getSharedPreferences(  "com.example.MyApp",Context.MODE_PRIVATE)!!
     private val editor = sharedPref.edit()

    fun userLoggedIn(user : User) {

        val gson = Gson()
        val json = gson.toJson(user) // myObject - instance of MyObject
        editor.putString(context.getString(R.string.user_logged_id_key), json)
        editor.putBoolean(context.getString(R.string.user_logged_in),true)

        editor.apply()
    }

    fun getUser(): User? {

        val gson = Gson()
        val json = sharedPref.getString(context.getString(R.string.user_logged_id_key), "")
        val obj = gson.fromJson<User>(json, User::class.java)

        return obj
    }

    fun userLogOut(){
        editor.putBoolean(context.getString(R.string.user_logged_in),false)
        editor.apply()
    }

    fun isUserLoggedIn(): Boolean {
        return sharedPref.getBoolean(context.getString(R.string.user_logged_in),false)
    }

}
