package com.example.gebruiker.beertimerefactor.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gebruiker.beertimerefactor.R
import dagger.android.support.DaggerFragment
import android.support.v7.widget.LinearLayoutManager
import com.example.gebruiker.beertimerefactor.model.Coordinate
import com.example.gebruiker.beertimerefactor.model.Event
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.ui.main.fragments.viewholder.HorizontalRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_feed_main.*
import kotlinx.android.synthetic.main.horizontal_recycyler_view.view.*
import java.util.ArrayList


class FeedMainFragment : DaggerFragment() {
    companion object {
        fun newInstance(): FeedMainFragment = FeedMainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_feed_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adapter = HorizontalRecyclerAdapter()

        val user1 = User()

        user1.name = "trOnk12"
        user1.avatar = "null"
        user1.id = "TESTID"

        val user2 = User()

        user2.name = "trOnk125"
        user2.avatar = "null"
        user2.id = "TESTID1"

        val userList = ArrayList<User>()

        userList.add(user1)
        userList.add(user2)

        val contributor = User()

        contributor.name = "owner"
        contributor.avatar = "null"
        contributor.id = "TESTID1"

        val latLng = Coordinate(35.00, 40.00)
        val latLng1 = Coordinate(-35.00, 40.00)
        val latLng2 = Coordinate(60.00, 10.00)

        val fakeEvent = Event("test", "Warszawa", "Poland", "Test event", contributor, userList, latLng)
        val fakeEvent1 = Event("test1", "Warszawa", "Poland", "Test event", contributor, userList, latLng1)
        val fakeEvent2 = Event("test2", "Warszawa", "Poland", "Test event", contributor, userList, latLng2)

        val eventList = ArrayList<Event>()
        eventList.add(fakeEvent)
        eventList.add(fakeEvent1)
        eventList.add(fakeEvent2)

        adapter.setData(eventList)

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        popular_events_rv.rv.layoutManager = layoutManager
        popular_events_rv.rv.adapter = adapter

        adapter.notifyDataSetChanged()

    }
}