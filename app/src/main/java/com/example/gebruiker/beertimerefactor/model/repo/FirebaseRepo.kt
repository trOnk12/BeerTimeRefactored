package com.example.gebruiker.beertimerefactor.model.repo

import com.example.gebruiker.beertimerefactor.model.Dialog
import com.example.gebruiker.beertimerefactor.model.Message
import com.example.gebruiker.beertimerefactor.model.User
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class FirebaseRepo(var sharedPreferencesRepository: SharedPreferencesRepository) {

    var fireBaseDataBase = FirebaseDatabase.getInstance()

    fun addUser(user: User) = fireBaseDataBase.getReference("users").child(user.id).setValue(user)

    fun addDialog(dialog: Dialog) = fireBaseDataBase.getReference("dialogs").child(dialog.id!!).setValue(dialog)

    fun addMessage(dialogID: String, message: Message) = fireBaseDataBase.getReference("chats").child(dialogID).push().setValue(message)

    fun getUsers(listener: ValueEventListener) = fireBaseDataBase.getReference("users").addValueEventListener(listener)

    fun getDialogs(param: String, listener: ValueEventListener) = fireBaseDataBase.getReference("dialogs").child(param).addListenerForSingleValueEvent(listener)

    fun getUser(uid: String, listener: ValueEventListener) = fireBaseDataBase.getReference("users").child(uid).addListenerForSingleValueEvent(listener)

    fun getDialogMessages(dialogID: String?, listener: ValueEventListener) = fireBaseDataBase.getReference("chats").child(dialogID!!).addListenerForSingleValueEvent(listener)

}
