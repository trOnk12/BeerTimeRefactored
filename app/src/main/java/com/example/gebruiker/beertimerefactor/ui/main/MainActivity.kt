package com.example.gebruiker.beertimerefactor.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import com.example.gebruiker.beertimerefactor.BaseFragmentActivity
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.ui.custom.CustomChatIcon
import com.example.gebruiker.beertimerefactor.ui.main.di.MainActivityPresenter
import com.example.gebruiker.beertimerefactor.ui.main.di.MainActivityView
import com.example.gebruiker.beertimerefactor.ui.dialogs.DialogsActivity
import com.example.gebruiker.beertimerefactor.ui.main.fragments.EventsMainFragment
import com.example.gebruiker.beertimerefactor.ui.main.fragments.FeedMainFragment
import com.example.gebruiker.beertimerefactor.ui.main.fragments.PeopleMainFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toolbar_.*
import javax.inject.Inject

class MainActivity : BaseFragmentActivity(), MainActivityView, CustomChatIcon.OnChatClickListener, BottomNavigationView.OnNavigationItemSelectedListener {
    companion object {
        fun createMainActivity(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    @Inject
    lateinit var mainActivityPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityPresenter.attachView(this)

        custom_chat.setOnChatClickListener(object:CustomChatIcon.OnChatClickListener{
            override fun onChatClick() {
                launchActivityWithFinish(DialogsActivity.createDialogsActivityIntent(applicationContext))
            }
        })

        bottom_navigation.setOnNavigationItemSelectedListener(this)

        mainActivityPresenter.getUser()

        val feedFragment = FeedMainFragment.newInstance()
        openFragment(feedFragment)

    }

    override fun displayUser(user: User) {
        user_name.text = user.name
    }

    override fun onChatClick() {
        startActivity(DialogsActivity.createDialogsActivityIntent(this))
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_feed -> {
                val feedFragment = FeedMainFragment.newInstance()
                openFragment(feedFragment)
                return true
            }
            R.id.action_event -> {
                val eventFragment = EventsMainFragment.newInstance()
                openFragment(eventFragment)
                return true
            }
            R.id.action_people -> {
                val peopleFragment = PeopleMainFragment.newInstance()
                openFragment(peopleFragment)
                return true
            }
        }
        return false
    }

}
