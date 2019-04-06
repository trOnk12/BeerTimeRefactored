package com.example.gebruiker.beertimerefactor.model.repo.remote

import com.example.gebruiker.beertimerefactor.model.Event
import com.example.gebruiker.beertimerefactor.model.firebase.FirebaseRepo
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class EventsRepository(private var firebaseRepo: FirebaseRepo) {

    fun getEvents(dataSnapShotListener: FirebaseRepo.DataSnapShotListener) {
        firebaseRepo.getEvents(object : ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                dataSnapShotListener.onDatSnapShotReceived(p0)
            }
        })
    }

    fun addEvent(event: Event) {
        firebaseRepo.addEvent(event)
    }


}