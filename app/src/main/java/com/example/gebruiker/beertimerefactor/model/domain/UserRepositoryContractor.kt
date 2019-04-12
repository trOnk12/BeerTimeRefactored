package com.example.gebruiker.beertimerefactor.model.domain

import com.example.gebruiker.beertimerefactor.model.User

interface UserRepositoryContractor {

    fun getUserById(id:String): User?
    fun loginUser(email:String,password:String)
    fun registerUser(email:String,password:String)
    fun getUser(): User?

}