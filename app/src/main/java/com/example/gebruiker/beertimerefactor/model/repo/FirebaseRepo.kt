package com.example.gebruiker.beertimerefactor.model.repo

import com.example.gebruiker.beertimerefactor.model.User
import com.google.firebase.database.FirebaseDatabase

class FirebaseRepo {

var fireBaseDataBase = FirebaseDatabase.getInstance()

    fun addUser(user : User){
        fireBaseDataBase
                .getReference("users")
                .setValue(user)
    }

}
