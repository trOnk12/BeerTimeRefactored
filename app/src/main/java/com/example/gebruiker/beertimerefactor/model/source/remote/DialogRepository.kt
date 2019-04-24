package com.example.gebruiker.beertimerefactor.model.source.remote

import com.example.gebruiker.beertimerefactor.model.Dialog
import com.example.gebruiker.beertimerefactor.model.firebase.FirebaseRepo
import com.example.gebruiker.beertimerefactor.model.source.local.UserCachedSource
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class DialogRepository(var userCachedSource: UserCachedSource, var firebaseRepo: FirebaseRepo) {

    fun getUsersDialogs():ArrayList<Dialog>{
        val dialogsList: ArrayList<Dialog> = ArrayList()

        val dialogsID = userCachedSource.getData()!!.dialogs

        for (dialogID in dialogsID) {

            firebaseRepo.getDialogs(dialogID, object : ValueEventListener {

                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(p0: DataSnapshot) {
                    val dialog = p0.getValue(Dialog::class.java)
                    dialogsList.add(dialog!!)
                }

            })

        }
        return dialogsList
    }

}