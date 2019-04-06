package com.example.gebruiker.beertimerefactor.model.repo.local

import android.content.Context
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.model.User
import com.google.gson.Gson
import javax.inject.Singleton

@Singleton
class SharedPreferencesRepository(var context: Context) {

    private val sharedPref = context.getSharedPreferences(  "com.example.MyApp",Context.MODE_PRIVATE)!!
    private val editor = sharedPref.edit()

    fun putUser(user : User) {
        val json = Gson().toJson(user) // myObject - instance of MyObject
        editor.putString(context.getString(R.string.user_logged_id_key), json)
        editor.apply()
    }

    fun getUser(): User? {
        val json = sharedPref.getString(context.getString(R.string.user_logged_id_key), "")
        return Gson().fromJson(json, User::class.java)
    }

}
