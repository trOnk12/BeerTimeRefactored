package com.example.gebruiker.beertimerefactor.model

import com.google.android.gms.maps.model.LatLng
import com.google.gson.annotations.SerializedName

data class Event(
        @SerializedName("id") var id: String,
        @SerializedName("city") var city: String,
        @SerializedName("country") var country: String,
        @SerializedName("name") var name: String,
        @SerializedName("organisator") var organisator: User?,
        @SerializedName("participants") var participants: ArrayList<User>?,
        @SerializedName("coordinate") var coordinate: Coordinate?) {
    constructor() : this("", "", "", "", null, null, null) {}
}
