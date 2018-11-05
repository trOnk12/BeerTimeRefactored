package com.example.gebruiker.beertimerefactor.model.repo

import com.example.gebruiker.beertimerefactor.model.Dialog
import com.example.gebruiker.beertimerefactor.model.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.GenericTypeIndicator



class FirebaseRepo {

var fireBaseDataBase = FirebaseDatabase.getInstance()


    fun addUser(user : User){
        fireBaseDataBase
                .getReference("users")
                .child(user.id)
                .setValue(user)
    }

    fun addDialog(dialog: Dialog) {
        fireBaseDataBase.getReference("dialogs")
                .child(dialog.id)
                .setValue(dialog)
    }


    fun getUsers(listener : ValueEventListener) {
        fireBaseDataBase.getReference("users").addValueEventListener(listener)
    }

    fun getDialogs(listener : ValueEventListener) {
        fireBaseDataBase.getReference("dialogs").addListenerForSingleValueEvent(listener)
    }
}
