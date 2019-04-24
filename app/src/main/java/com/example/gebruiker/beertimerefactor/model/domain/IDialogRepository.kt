package com.example.gebruiker.beertimerefactor.model.domain

import com.example.gebruiker.beertimerefactor.model.User

interface IDialogRepository {

    fun getDialogById(id:String)
    fun getAllUserDialogs(user:User)

}