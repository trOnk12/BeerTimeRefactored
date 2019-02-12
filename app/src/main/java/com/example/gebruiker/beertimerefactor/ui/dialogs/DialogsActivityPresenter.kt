package com.example.gebruiker.beertimerefactor.ui.dialogs

import com.example.gebruiker.beertimerefactor.R.id.dialogsList
import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.Dialog
import com.example.gebruiker.beertimerefactor.model.Message
import com.example.gebruiker.beertimerefactor.model.repo.FirebaseRepo
import com.example.gebruiker.beertimerefactor.model.repo.SharedPreferencesRepository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class DialogsActivityPresenter(var sharedPreferencesRepository: SharedPreferencesRepository, var firebaseRepo: FirebaseRepo) : BasePresenter<DialogsView>() {

    fun getDialogsForUser() {
        val dialogsList: ArrayList<Dialog> = ArrayList()
        val dialogsID = sharedPreferencesRepository.getUser()!!.dialogs

        for (dialogID in dialogsID) {

            firebaseRepo.getDialogs(dialogID, object : ValueEventListener {

                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(p0: DataSnapshot) {
                    val dialog = p0.getValue(Dialog::class.java)
                    dialogsList.add(dialog!!)
                    getView().displayViews(dialogsList)
                }

            })

        }


    }

    fun openDialogMessages(dialogID: String?) {

        firebaseRepo.getDialogMessages(dialogID, object : ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                var messageList : ArrayList<Message> =  ArrayList()

                for (children in p0.children) {
                    var message = children.getValue(Message::class.java)
                    messageList.add(message!!)
                }

                getView().openChatActivity(messageList)
            }

        })

    }


}