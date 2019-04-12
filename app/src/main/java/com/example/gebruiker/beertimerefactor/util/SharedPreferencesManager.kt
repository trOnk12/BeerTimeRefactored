package com.example.gebruiker.beertimerefactor.util

import android.content.Context


class SharedPreferencesManager(var context: Context) {

    private val sharedPref = context.getSharedPreferences("com.example.MyApp", Context.MODE_PRIVATE)!!
    private val editor = sharedPref.edit()

    fun putData(key: String, data: String) {
        val test = editor.putString(key, data)
        editor.putString(key, data)
        editor.apply()
    }

    fun getData(key: String): String? {
        return sharedPref.getString(key, "")
    }

}