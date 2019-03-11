package com.example.gebruiker.beertimerefactor.ui.map

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.graphics.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.WindowManager
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.ui.main.MainActivity

import android.view.MenuInflater
import com.example.gebruiker.beertimerefactor.R.id.search_toolbar
import com.example.gebruiker.beertimerefactor.model.Event
import com.google.android.gms.maps.*
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_maps.*
import kotlinx.android.synthetic.main.custom_search_toolbar.*
import javax.inject.Inject
import android.support.v4.content.ContextCompat
import android.graphics.drawable.Drawable
import com.google.android.gms.maps.model.*


class MapsActivity : DaggerAppCompatActivity(), OnMapReadyCallback,MapsView, GoogleMap.OnInfoWindowClickListener {

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
            mMap.addMarker(MarkerOptions().position(eventPosition).title(event.name).icon(bitmapDescriptorFromVector(this, R.drawable.ic_beer_map)))
        }
        mMap.setOnInfoWindowClickListener(this)
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

    private fun bitmapDescriptorFromVector(context: Context, vectorResId: Int): BitmapDescriptor {
        val vectorDrawable = ContextCompat.getDrawable(context, vectorResId)
        vectorDrawable!!.setBounds(10, 10, vectorDrawable.intrinsicWidth-10, vectorDrawable.intrinsicHeight-10)
        val bitmap = Bitmap.createBitmap(vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.color = Color.parseColor("#536dfe")
        canvas.drawCircle(vectorDrawable.intrinsicWidth.toFloat()/2, vectorDrawable.intrinsicHeight.toFloat()/2, 35.0F, paint)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }

    override fun onInfoWindowClick(p0: Marker?) {

    }

}
