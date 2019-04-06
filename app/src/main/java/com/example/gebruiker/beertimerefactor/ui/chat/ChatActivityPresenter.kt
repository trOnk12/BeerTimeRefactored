package com.example.gebruiker.beertimerefactor.ui.chat

import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.Message
import com.example.gebruiker.beertimerefactor.model.firebase.FirebaseRepo
import com.example.gebruiker.beertimerefactor.model.repo.local.SharedPreferencesRepository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import java.util.*

class ChatActivityPresenter(var sharedPreferencesRepository: SharedPreferencesRepository, var firebaseRepo: FirebaseRepo) : BasePresenter<ChatAcitivtyView>() {


    fun getChatHistory(dialogID: String?) {

        firebaseRepo.getDialogMessages(dialogID, object : ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                val messageList: ArrayList<Message> = ArrayList()

                for (children in p0.children) {
                    val message = children.getValue(Message::class.java)
                    messageList.add(message!!)
                }

                getView().displayChatHistory(messageList)
            }

        })

    }

    fun addMessage(input: CharSequence?, dialogID: String) {
        val message = Message()

        message.setUser(sharedPreferencesRepository.getUser())
        message.id = firebaseRepo.fireBaseDataBase.reference.push().key
        message.text = input.toString()

        val date = Date()
        date.time = System.currentTimeMillis()
        message.createdAt = date

        firebaseRepo.addMessage(dialogID, message)

        getView().displayNewMessage(message)

    }


}