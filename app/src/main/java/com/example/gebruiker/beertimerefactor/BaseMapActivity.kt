package com.example.gebruiker.beertimerefactor

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.v4.content.ContextCompat
import com.example.gebruiker.beertimerefactor.ui.map.MapsView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.Marker
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseMapActivity: DaggerAppCompatActivity(), MapsView{

    fun bitmapDescriptorFromVector(context: Context, vectorResId: Int): BitmapDescriptor {
        val vectorDrawable = ContextCompat.getDrawable(context, vectorResId)
        vectorDrawable!!.setBounds(10, 10, vectorDrawable.intrinsicWidth - 10, vectorDrawable.intrinsicHeight - 10)
        val bitmap = Bitmap.createBitmap(vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.color = Color.parseColor("#536dfe")
        canvas.drawCircle(vectorDrawable.intrinsicWidth.toFloat() / 2, vectorDrawable.intrinsicHeight.toFloat() / 2, 35.0F, paint)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}