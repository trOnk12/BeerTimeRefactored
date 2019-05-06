package com.example.gebruiker.beertimerefactor.model.domain

import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.model.source.remote.UserRemoteSource

interface IUserRepository{

    fun getUserById(id:String,dataListener:IBaseRepository<User>)
    fun loginUser(email:String,password:String,onSuccessListener:IBaseRepository<Boolean>)
    fun registerUser(email:String,password:String,onSuccessListener: IBaseRepository<Boolean>)
    fun getUser(): User?
    fun addUser(user:User)
    fun logout(): Boolean
    fun getUserFriends(userFriendsListener: UserRemoteSource.UserFriendsListener)

}