package com.example.gebruiker.beertimerefactor.model.source.remote

import com.example.gebruiker.beertimerefactor.model.Event
import com.example.gebruiker.beertimerefactor.model.firebase.FirebaseRepo
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class EventsRepository(private var firebaseRepo: FirebaseRepo) {

    interface OnDataRetrievedListener{
        fun onDataRetrieved(data:ArrayList<Event>)
    }

    fun getEvents(dataSnapShotListener: OnDataRetrievedListener) {
        firebaseRepo.getEvents(object : ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(dataSnapShot: DataSnapshot) {

                val eventsList: java.util.ArrayList<Event> = java.util.ArrayList()

                for (children in dataSnapShot.children) {
                    val event = children.getValue(Event::class.java)
                    eventsList.add(event!!)
                }

                dataSnapShotListener.onDataRetrieved(eventsList)
            }
        })
    }

    fun addEvent(event: Event) {
        firebaseRepo.addEvent(event)
    }


}