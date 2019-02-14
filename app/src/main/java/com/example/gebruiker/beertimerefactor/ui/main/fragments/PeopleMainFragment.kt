package com.example.gebruiker.beertimerefactor.ui.main.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gebruiker.beertimerefactor.R
import dagger.android.support.DaggerFragment
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
        initOptionsCard()
    }

    private fun initOptionsCard() {

        event_options.setOption1Listener(View.OnClickListener {
            it.id = R.id.option_1
        })


        event_options.setOption2Listener(View.OnClickListener {
            Log.d("TEST","test1")
        })

        event_options.setOption1Title(getString(R.string.people_option1_title))
        event_options.setOption1Body(getString(R.string.people_option1_body))

        event_options.setOption2Title(getString(R.string.people_option2_title))
        event_options.setOption2Body(getString(R.string.people_option2_body))

    }
}