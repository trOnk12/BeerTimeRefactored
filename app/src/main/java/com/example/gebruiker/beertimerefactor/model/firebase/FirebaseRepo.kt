package com.example.gebruiker.beertimerefactor.model.firebase

import android.util.Log
import com.example.gebruiker.beertimerefactor.model.Dialog
import com.example.gebruiker.beertimerefactor.model.Event
import com.example.gebruiker.beertimerefactor.model.Message
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.model.repo.local.SharedPreferencesRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class FirebaseRepo(var sharedPreferencesRepository: SharedPreferencesRepository) {

    interface DataSnapShotListener {
        fun onDatSnapShotReceived(dataSnapShot: DataSnapshot)
    }

    var fireBaseDataBase = FirebaseDatabase.getInstance()
    private var fireBaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun addUser(user: User) = fireBaseDataBase.getReference("users").child(user.id).setValue(user)

    fun addDialog(dialog: Dialog) = fireBaseDataBase.getReference("dialogs").child(dialog.id!!).setValue(dialog)

    fun addMessage(dialogID: String, message: Message) = fireBaseDataBase.getReference("chats").child(dialogID).push().setValue(message)

    fun getUsers(listener: ValueEventListener) = fireBaseDataBase.getReference("users").addValueEventListener(listener)

    fun getDialogs(param: String, listener: ValueEventListener) = fireBaseDataBase.getReference("dialogs").child(param).addListenerForSingleValueEvent(listener)

    fun getUser(uid: String, listener: ValueEventListener) = fireBaseDataBase.getReference("users").child(uid).addListenerForSingleValueEvent(listener)

    fun getDialogMessages(dialogID: String?, listener: ValueEventListener) = fireBaseDataBase.getReference("chats").child(dialogID!!).addListenerForSingleValueEvent(listener)

    fun getEvents(listener: ValueEventListener) = fireBaseDataBase.getReference("events").addListenerForSingleValueEvent(listener)

    fun addEvent(event: Event) = fireBaseDataBase.getReference("events").child(event.id).setValue(event)

    fun registerUser(email: String, password: String, callBackListener: FireBaseAuthHelper.CallBackListener) {
        fireBaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = fireBaseAuth.currentUser

                        if (user != null) {
                            val userShared = User()
                            userShared.id = user.uid
                            userShared.avatar = "null"
                            userShared.name = "trOnk12"
                            userShared.dialogs = arrayListOf("-LPQs6HSEb1o8vQzY0-w", "-LPQre2Qxddw5VWm-PAi", "-LPQs9TfbKOO6bh7Y4an")
                            addUser(userShared)
                        }

                        callBackListener.success()
                    } else {
                        Log.d("TEST", "error" + task.exception)
                        callBackListener.error()
                    }
                }
    }


    fun loginUser(email: String, password: String, callback: FireBaseAuthHelper.CallBackListener) {

        fireBaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                getUser(fireBaseAuth.currentUser!!.uid, object : ValueEventListener {

                    override fun onCancelled(p0: DatabaseError) {
                        callback.error()
                    }

                    override fun onDataChange(p0: DataSnapshot) {
                        val user = p0.getValue(User::class.java)
                        sharedPreferencesRepository.putUser(user!!)
                        callback.success()
                    }

                })

            } else {
                callback.error()
            }
        }
    }

}
