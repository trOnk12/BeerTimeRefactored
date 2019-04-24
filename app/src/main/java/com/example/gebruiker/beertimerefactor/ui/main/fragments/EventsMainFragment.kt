package com.example.gebruiker.beertimerefactor.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gebruiker.beertimerefactor.BaseFragment
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.ui.filter.FilterEventsActivity
import com.example.gebruiker.beertimerefactor.ui.map.MapsActivity
import kotlinx.android.synthetic.main.custom_two_option_cards.view.*
import kotlinx.android.synthetic.main.fragment_event_main.*

class EventsMainFragment : BaseFragment() {


    companion object {
        fun newInstance(): EventsMainFragment = EventsMainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_event_main, container, false)
    }

    override fun initializeLayout() {
        events_two_options.option1_body.setOnClickListener { startActivity(MapsActivity.createMapActivity(activity!!.applicationContext)) }
        events_two_options.option2_body.setOnClickListener { startActivity(FilterEventsActivity.createFilterEventActivity(activity!!.applicationContext)) }

        events_two_options.option1_title.text = getString(R.string.event_option1_title)
        events_two_options.option1_body.text = getString(R.string.event_option1_body)

        events_two_options.option2_title.text = getString(R.string.event_option2_title)
        events_two_options.option2_body.text = getString(R.string.event_option2_body)
    }

}