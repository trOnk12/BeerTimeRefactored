package com.example.gebruiker.beertimerefactor.ui.map

import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.Coordinate
import com.example.gebruiker.beertimerefactor.model.Event
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.model.firebase.FirebaseRepo
import com.example.gebruiker.beertimerefactor.model.source.remote.EventsRepository
import com.google.firebase.database.DataSnapshot

class MapsPresenter(var eventsRepository: EventsRepository) : BasePresenter<MapsView>() {

    fun getMarkers() {
        eventsRepository.getEvents(object : EventsRepository.OnDataRetrievedListener{
            override fun onDataRetrieved(data: ArrayList<Event>) {
                getView().displayEventsOnMap(data)
            }
        })
    }

}