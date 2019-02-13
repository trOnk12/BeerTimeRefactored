package com.example.gebruiker.beertimerefactor.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gebruiker.beertimerefactor.R
import dagger.android.support.DaggerAppCompatDialogFragment
import dagger.android.support.DaggerFragment

class EventsMainFragment : DaggerFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_event_main, container, false)

    }
}