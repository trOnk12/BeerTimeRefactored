package com.example.gebruiker.beertimerefactor.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.example.gebruiker.beertimerefactor.BaseActivity
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

class MainActivity : BaseActivity(), MainActivityView, CustomChatIcon.OnChatClickListener, BottomNavigationView.OnNavigationItemSelectedListener {
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
        init()

        mainActivityPresenter.getUserAndDisplay()
    }

    private fun init() {
        setUpToolbar()

        mainActivityPresenter.attachView(this)

        custom_chat.setOnChatClickListener(this)
        bottom_navigation.setOnNavigationItemSelectedListener(this)
    }

    private fun setUpToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    override fun displayUser(user: User) {
        user_name.text = user.name
    }

    override fun onChatClick() {
        val intent = Intent(this, DialogsActivity::class.java)
        startActivity(intent)
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

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left)
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}
