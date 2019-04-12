package com.example.gebruiker.beertimerefactor.ui.map

import android.content.Context
import android.content.Intent
import android.graphics.*
import android.os.Bundle
import com.example.gebruiker.beertimerefactor.R

import com.example.gebruiker.beertimerefactor.model.Event
import com.google.android.gms.maps.*
import kotlinx.android.synthetic.main.activity_maps.*
import kotlinx.android.synthetic.main.custom_search_toolbar.*
import javax.inject.Inject
import com.example.gebruiker.beertimerefactor.BaseMapActivity
import com.example.gebruiker.beertimerefactor.ui.event.EventDescriptionActivity
import com.google.android.gms.maps.model.*


class MapsActivity : BaseMapActivity() {
    companion object {
        fun createMapActivity(context: Context): Intent {
            return Intent(context, MapsActivity::class.java)
        }
    }

    private lateinit var mMap: GoogleMap
    var markerHashMap = HashMap<String,Event>()

    @Inject
    lateinit var mapsPresenter: MapsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        mapsPresenter.attachView(this)

        setSupportActionBar(findViewById(R.id.search_bar))
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        search_bar.navigationIcon!!.setColorFilter(resources.getColor(R.color.white), PorterDuff.Mode.SRC_ATOP)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }


    override fun displayEventsOnMap(eventList: ArrayList<Event>) {

        val latLngBounds = LatLngBounds.Builder()

        for (event in eventList) {
            val eventPosition = LatLng(event.coordinate!!.longtitude, event.coordinate!!.latitude)
            latLngBounds.include(eventPosition)
            val marker = mMap.addMarker(MarkerOptions().position(eventPosition).title(event.name).icon(bitmapDescriptorFromVector(this, R.drawable.ic_beer_map)))
            markerHashMap[marker.id] = event
        }

        mMap.setOnInfoWindowClickListener(this)
        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds.build(), 200,
                300, 40))

    }

    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap
        mMap.setOnMapClickListener { search_toolbar.closeSearchInput() }

        mapsPresenter.getEvents()

    }


    override fun onInfoWindowClick(p0: Marker?) {
        startActivity(EventDescriptionActivity.createEventDescriptionActivity(this, markerHashMap[p0!!.id]))
    }

}
