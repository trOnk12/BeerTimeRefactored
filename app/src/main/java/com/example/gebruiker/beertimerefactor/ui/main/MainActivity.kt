package com.example.gebruiker.beertimerefactor.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
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

class MainActivity : BaseFragmentActivity(), MainActivityView, BottomNavigationView.OnNavigationItemSelectedListener {
    companion object {
        fun createMainActivity(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    @Inject
    lateinit var mainActivityPresenter: MainActivityPresenter
    private lateinit var pagerAdapter: ScreenSlidePagerAdapter

    override fun attachPresenter() {
        mainActivityPresenter.attachView(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        custom_chat.setOnChatClickListener(object : CustomChatIcon.OnChatClickListener {
            override fun onChatClick() {
                launchActivityWithFinish(DialogsActivity.createDialogsActivityIntent(applicationContext))
            }
        })

        bottom_navigation.setOnNavigationItemSelectedListener(this)

        pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        view_pager.adapter = pagerAdapter

        mainActivityPresenter.getUser()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_feed -> {
                view_pager.currentItem = 0
                return true
            }
            R.id.action_event -> {
                view_pager.currentItem = 1
                return true
            }
            R.id.action_people -> {
                view_pager.currentItem = 2
                return true
            }
        }
        return false
    }

    override fun displayUser(user: User) {
        user_name.text = user.name
    }

}
