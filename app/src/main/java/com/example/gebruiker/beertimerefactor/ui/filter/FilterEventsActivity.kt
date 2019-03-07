package com.example.gebruiker.beertimerefactor.ui.filter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.ui.map.MapsActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_filter_event.*
import android.view.ViewTreeObserver

class FilterEventsActivity : DaggerAppCompatActivity() {
    companion object {
        fun createFilterEventActivity(context: Context): Intent {
            return Intent(context, FilterEventsActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_event)

        event_enviroment_options.viewTreeObserver.addOnGlobalLayoutListener { (event_enviroment_options.selectedView as TextView).setTextColor(Color.WHITE) }
        event_type_options.viewTreeObserver.addOnGlobalLayoutListener { (event_type_options.selectedView as TextView).setTextColor(Color.WHITE) }

    }
}