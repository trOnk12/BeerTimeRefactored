package com.example.gebruiker.beertimerefactor.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.ui.filter.FilterEventsActivity
import com.example.gebruiker.beertimerefactor.ui.map.MapsActivity
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.custom_two_option_cards.view.*
import kotlinx.android.synthetic.main.fragment_event_main.*

class PeopleMainFragment : DaggerFragment() {
    companion object {
        fun newInstance(): PeopleMainFragment = PeopleMainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_people_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initializeView()
    }

    private fun initializeView() {

        events_two_options.option1_body.setOnClickListener { startActivity( MapsActivity.createMapActivity(activity!!.applicationContext)) }
        events_two_options.option2_body.setOnClickListener { startActivity(FilterEventsActivity.createFilterEventActivity(activity!!.applicationContext)) }

        events_two_options.option1_title.text = getString(R.string.people_option1_body)
        events_two_options.option1_body.text = getString(R.string.people_option1_body)

        events_two_options.option2_title.text = getString(R.string.people_option2_title)
        events_two_options.option2_body.text = getString(R.string.people_option2_body)

    }

}