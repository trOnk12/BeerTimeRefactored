package com.example.gebruiker.beertimerefactor.util

import com.example.gebruiker.beertimerefactor.model.Coordinate
import com.example.gebruiker.beertimerefactor.model.Event
import com.example.gebruiker.beertimerefactor.model.User
import java.util.ArrayList

class FakeDataGenerator {

    fun generateEvents(){
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

        val latLng= Coordinate(35.00,40.00)
        val latLng1= Coordinate(-35.00,40.00)
        val latLng2= Coordinate(60.00,10.00)

        val fakeEvent = Event("test", "Warszawa", "Poland", "Test event", contributor, userList,latLng)
        val fakeEvent1 = Event("test1", "Warszawa", "Poland", "Test event", contributor, userList,latLng1)
        val fakeEvent2 = Event("test2", "Warszawa", "Poland", "Test event", contributor, userList,latLng2)
    }
}