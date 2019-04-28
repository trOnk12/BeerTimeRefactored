package com.example.gebruiker.beertimerefactor.model.domain

import com.example.gebruiker.beertimerefactor.model.User

interface IUserRepository{

    fun getUserById(id:String,dataListener:IBaseRepository<User>)
    fun loginUser(email:String,password:String,onSuccessListener:IBaseRepository<Boolean>)
    fun registerUser(email:String,password:String,onSuccessListener: IBaseRepository<Boolean>)
    fun getUser(): User?
    fun addUser(user:User)
    fun getUserFriends():ArrayList<User>?
    fun logout(): Boolean

}