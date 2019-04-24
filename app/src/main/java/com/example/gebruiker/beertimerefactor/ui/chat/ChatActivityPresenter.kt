package com.example.gebruiker.beertimerefactor.ui.chat

import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.repository.ChatRepository
import com.example.gebruiker.beertimerefactor.model.repository.IUserRepository

class ChatActivityPresenter(userRepository: IUserRepository, chatRepository: ChatRepository) : BasePresenter<ChatAcitivtyView>() {

    fun getChatHistory(dialogID: String?) {



//
//
//
//
//        firebaseRepo.getDialogMessages(dialogID, object : ValueEventListener {
//
//            override fun onCancelled(p0: DatabaseError) {
//
//            }
//
//            override fun onDataChange(p0: DataSnapshot) {
//                val messageList: ArrayList<Message> = ArrayList()
//
//                for (children in p0.children) {
//                    val message = children.getValue(Message::class.java)
//                    messageList.add(message!!)
//                }
//
//                getView().displayChatHistory(messageList)
//            }
//
//        })

    }

    fun addMessage(input: CharSequence?, dialogID: String) {







//        val message = Message()
//
//        message.setUser(userCachedSource.getUser())
//        message.id = firebaseRepo.fireBaseDataBase.reference.push().key
//        message.text = input.toString()
//
//        val date = Date()
//        date.time = System.currentTimeMillis()
//        message.createdAt = date
//
//        firebaseRepo.addMessage(dialogID, message)
//
//        getView().displayNewMessage(message)

    }


}