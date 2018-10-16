package com.example.gebruiker.beertimerefactor.model

import com.stfalcon.chatkit.commons.models.IUser

class User(var mAvatar:String, var mName : String, var mId : String) : IUser {

    override fun getAvatar(): String {
       return mAvatar
    }

    override fun getName(): String {
       return mName
    }

    override fun getId(): String {
        return mId
    }

}