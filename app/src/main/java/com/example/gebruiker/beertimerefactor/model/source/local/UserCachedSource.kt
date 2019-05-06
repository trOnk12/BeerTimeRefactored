package com.example.gebruiker.beertimerefactor.model.source.local

import com.example.gebruiker.beertimerefactor.BaseCachedSource
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.util.SharedPreferencesManager
import com.google.gson.Gson
import javax.inject.Singleton

@Singleton
class UserCachedSource(var sharedPreferencesManager: SharedPreferencesManager) : BaseCachedSource<User>() {
    companion object {
        const val USER_KEY = "USER"
    }

    override fun putData(data: User) {
        sharedPreferencesManager.putData(USER_KEY, Gson().toJson(data))
    }

    override fun getData(): User? {
        val user = Gson().fromJson(sharedPreferencesManager.getData(USER_KEY), User::class.java)
        return user
    }

    override fun empty(): Boolean {
        return sharedPreferencesManager.clearData()
    }

}