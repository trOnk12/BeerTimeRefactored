package com.example.gebruiker.beertimerefactor.model.source.remote

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase

abstract class BaseRemoteSource {


    interface DataSnapShotListener {
        fun onDatSnapShotReceived(dataSnapShot: DataSnapshot)
        fun onDataSnapShotInterrupted()
    }

    var fireBaseDataBase = FirebaseDatabase.getInstance()
    var fireBaseAuth: FirebaseAuth = FirebaseAuth.getInstance()


}