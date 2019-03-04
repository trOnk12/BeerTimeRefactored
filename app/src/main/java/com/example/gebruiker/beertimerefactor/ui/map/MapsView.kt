package com.example.gebruiker.beertimerefactor.ui.map

import com.example.gebruiker.beertimerefactor.baseMVP.BaseView
import com.example.gebruiker.beertimerefactor.model.Event

interface MapsView :BaseView {
    fun displayEventsOnMap(eventList: ArrayList<Event>)
}