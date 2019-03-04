package com.example.gebruiker.beertimerefactor.model.service

import android.content.Context
import android.util.Log
import dagger.android.DaggerActivity
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.RectangularBounds
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.PlacesClient
import com.google.android.libraries.places.internal.it


class GoogleService(var context: Context) {

     var query = "warszawa"
    var apiKey = "AIzaSyDLaojhXev1iLXIy7mTDXUv1Yfe33CBS0M"
    var places = Places.initialize(context,apiKey)
     var placesClient : PlacesClient = Places.createClient(context)
    var token = AutocompleteSessionToken.newInstance()

    var bounds = RectangularBounds.newInstance(
            LatLng(-33.880490, 151.184363),
            LatLng(-33.858754, 151.229596))
    // Use the builder to create a FindAutocompletePredictionsRequest.
    var request = FindAutocompletePredictionsRequest.builder()
            // Call either setLocationBias() OR setLocationRestriction().
            .setLocationBias(bounds)
            //.setLocationRestriction(bounds)
            .setCountry("au")
            .setTypeFilter(TypeFilter.ADDRESS)
            .setSessionToken(token)
            .setQuery(query)
            .build()

//
//    fun getAutoComplete(): ArrayList<String> {
////         val placesNameList : ArrayList<String> = ArrayList()
////         placesClient.findAutocompletePredictions(request).addOnSuccessListener {
////             val listPredction = it.autocompletePredictions
////             for(data in listPredction){
////                 Log.d("TEST","name" + data.getFullText(null))
////                 placesNameList.add(data.getFullText(null).toString())
////             }
////         }
////                 .addOnFailureListener{
////                     Log.d("TEST",it.message)
////                 }
////         return placesNameList
//     }

}