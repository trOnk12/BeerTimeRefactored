package com.example.gebruiker.beertimerefactor.ui.filter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.ui.map.MapsActivity
import dagger.android.support.DaggerAppCompatActivity

class FilterEventsActivity : DaggerAppCompatActivity() {
    companion object {
        fun createFilterEventActivity(context: Context): Intent {
            return Intent(context, FilterEventsActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_filter_event)
    }
}