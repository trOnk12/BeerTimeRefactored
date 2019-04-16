package com.example.gebruiker.beertimerefactor.model.domain

import com.example.gebruiker.beertimerefactor.model.User

interface UserRepositoryContractor{

    fun getUserById(id:String,dataListener:BaseRepositoryContractor<User>)
    fun loginUser(email:String,password:String,onSuccessListener:BaseRepositoryContractor<Boolean>)
    fun registerUser(email:String,password:String,onSuccessListener: BaseRepositoryContractor<Boolean>)
    fun getUser(): User?

}