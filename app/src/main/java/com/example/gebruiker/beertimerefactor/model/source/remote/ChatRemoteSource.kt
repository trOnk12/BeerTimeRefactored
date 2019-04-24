package com.example.gebruiker.beertimerefactor.model.source.remote

import com.example.gebruiker.beertimerefactor.model.Message
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class ChatRemoteSource : BaseRemoteSource() {

    fun getUsersChats(userID:String,listener: DataSnapShotListener){
        fireBaseDataBase.getReference("dialogs").child(userID).addListenerForSingleValueEvent(object:ValueEventListener{

            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {

                listener.onDatSnapShotReceived(p0)
//                val messageList: ArrayList<Message> = ArrayList()
//
//                for (children in p0.children) {
//                    val message = children.getValue(Message::class.java)
//                    messageList.add(message!!)
//                }
//
//
//                getView().displayChatHistory(messageList)
            }


        })
    }
}