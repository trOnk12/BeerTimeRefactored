package com.example.gebruiker.beertimerefactor.model

import com.google.android.gms.maps.model.LatLng

data class Event(var id: String, var city: String, var country: String, var name: String, var organisator: User?, var participants: ArrayList<User>?, var coordinate: Coordinate?){
    constructor() : this("","","","",null,null,null) {}
}
