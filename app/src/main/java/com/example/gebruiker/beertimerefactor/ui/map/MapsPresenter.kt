package com.example.gebruiker.beertimerefactor.ui.map

import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.Coordinate
import com.example.gebruiker.beertimerefactor.model.Event
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.model.repo.FirebaseRepo
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import java.util.ArrayList

class MapsPresenter(var firebaseRepo: FirebaseRepo) : BasePresenter<MapsView>() {

    fun getAllEvents() {
        val user1 = User()

        user1.name = "trOnk12"
        user1.avatar = "null"
        user1.id = "TESTID"

        val user2 = User()

        user2.name = "trOnk125"
        user2.avatar = "null"
        user2.id = "TESTID1"

        val userList = ArrayList<User>()

        userList.add(user1)
        userList.add(user2)

        val contributor = User()

        contributor.name = "owner"
        contributor.avatar = "null"
        contributor.id = "TESTID1"

        val latLng= Coordinate(12.00,1.00)
        val latLng1= Coordinate(-4.00,3.00)
        val latLng2= Coordinate(5.00,7.00)

        val fakeEvent = Event("test12asd3", "Warszawa", "Poland", "Test event", contributor, userList,latLng)
        val fakeEvent1 = Event("test3ad1", "Warszawa", "Poland", "Test event", contributor, userList,latLng1)
        val fakeEvent2 = Event("test43asdas2", "Warszawa", "Poland", "Test event", contributor, userList,latLng2)

        firebaseRepo.addEvent(fakeEvent)
        firebaseRepo.addEvent(fakeEvent1)
        firebaseRepo.addEvent(fakeEvent2)

        firebaseRepo.getEvents(object : ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                val eventsList: ArrayList<Event> = ArrayList()

                for (children in p0.children) {
                    val event = children.getValue(Event::class.java)
                    eventsList.add(event!!)
                }

                getView().displayEventsOnMap(eventsList)
            }
        })
    }

}