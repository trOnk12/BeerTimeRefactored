package com.example.gebruiker.beertimerefactor.model.repo

import com.example.gebruiker.beertimerefactor.model.Dialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class DialogRepository(var sharedPreferencesRepository: SharedPreferencesRepository,var firebaseRepo: FirebaseRepo) {


    fun getUsersDialogs():ArrayList<Dialog>{
        val dialogsList: ArrayList<Dialog> = ArrayList()

        val dialogsID = sharedPreferencesRepository.getUser()!!.dialogs

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