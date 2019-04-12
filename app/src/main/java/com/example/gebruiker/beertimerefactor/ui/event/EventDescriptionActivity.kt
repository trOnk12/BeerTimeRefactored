package com.example.gebruiker.beertimerefactor.ui.event

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.model.Event
import com.example.gebruiker.beertimerefactor.ui.event.viewholder.PatricipiantsViewHolder
import com.google.gson.Gson
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.fragment_event_description.*
import kotlinx.android.synthetic.main.horizontal_recycyler_view.view.*
import android.support.v7.widget.LinearLayoutManager


class EventDescriptionActivity : DaggerAppCompatActivity() {
    companion object {
        var EVENT_EXTRA = "EVENT"
        fun createEventDescriptionActivity(context: Context, event: Event?): Intent {
            val intent = Intent(context, EventDescriptionActivity::class.java)
            intent.putExtra(Gson().toJson(event), EVENT_EXTRA)
            return intent
        }
    }

    private val adapter = PatricipiantsViewHolder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_event_description)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        patricipiants_item_holder.rv.layoutManager = linearLayoutManager
        patricipiants_item_holder.rv.setHasFixedSize(true)

        setView(retrieveEventFromIntent())
    }

    private fun retrieveEventFromIntent(): Event? {
        val jsonEvent = intent.getStringExtra(EventDescriptionActivity.EVENT_EXTRA)
        return Gson().fromJson(jsonEvent, Event::class.java)
    }

    private fun setView(event: Event?) {
        event_title.text = event!!.name

        adapter.setItems(event.participants!!)
        patricipiants_item_holder.rv.adapter = adapter
    }
}