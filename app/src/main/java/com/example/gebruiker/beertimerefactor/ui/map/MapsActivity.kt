package com.example.gebruiker.beertimerefactor.ui.map

import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.WindowManager
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.ui.main.MainActivity

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import android.view.MenuInflater
import com.example.gebruiker.beertimerefactor.model.Event
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLngBounds
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_maps.*
import kotlinx.android.synthetic.main.custom_search_toolbar.*
import javax.inject.Inject

class MapsActivity : DaggerAppCompatActivity(), OnMapReadyCallback,MapsView {
    companion object {
        fun createMapActivity(context: Context): Intent {
            return Intent(context, MapsActivity::class.java)
        }
    }

    @Inject
    lateinit var mapsPresenter: MapsPresenter
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        init()
    }

    private fun init() {
        mapsPresenter.attachView(this)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setUpToolbar()
        setUpMap()
    }

    private fun setUpToolbar() {
        setSupportActionBar(findViewById(R.id.search_bar))
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        search_bar.navigationIcon!!.setColorFilter(resources.getColor(R.color.white), PorterDuff.Mode.SRC_ATOP)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setUpMap() {

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun displayEventsOnMap(eventList: ArrayList<Event>) {

        val latLngBounds = LatLngBounds.Builder()

        for(event in eventList){
            val eventPosition = LatLng(event.coordinate!!.longtitude, event.coordinate!!.latitude)
            latLngBounds.include(eventPosition)
            mMap.addMarker(MarkerOptions().position(eventPosition).title(event.name))
        }

        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds.build(),200,
                300,40))
    }

    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap
        mMap.setOnMapClickListener {
            search_toolbar.closeSearchInput()
        }

        mapsPresenter.getAllEvents()

    }
}
