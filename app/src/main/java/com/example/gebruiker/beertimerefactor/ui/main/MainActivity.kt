package com.example.gebruiker.beertimerefactor.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import com.example.gebruiker.beertimerefactor.BaseFragmentActivity
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.ui.custom.CustomChatIcon
import com.example.gebruiker.beertimerefactor.ui.main.di.MainActivityPresenter
import com.example.gebruiker.beertimerefactor.ui.main.di.MainActivityView
import com.example.gebruiker.beertimerefactor.ui.dialogs.DialogsActivity
import com.example.gebruiker.beertimerefactor.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_main_toolbar.*
import kotlinx.android.synthetic.main.custom_tab.view.*
import javax.inject.Inject

class MainActivity : BaseFragmentActivity(), MainActivityView{
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
        setView()

        mainActivityPresenter.getUser()
    }

    private fun setView() {
        profile_image.setOnClickListener { createPopupMenu(it) }

        custom_chat.setOnChatClickListener(object : CustomChatIcon.OnChatClickListener {
            override fun onChatClick() {
                startActivity(DialogsActivity.createDialogsActivityIntent(applicationContext))
            }
        })

        pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        view_pager.adapter = pagerAdapter

        val view1 = layoutInflater.inflate(R.layout.custom_tab, null)
        view1.icon.setBackgroundResource(R.drawable.ic_beer)
        tablayout.addTab(tablayout.newTab().setCustomView(view1))


        val view2 = layoutInflater.inflate(R.layout.custom_tab, null)
         view2.icon.setBackgroundResource(R.drawable.ic_event_black_24dp)
        tablayout.addTab(tablayout.newTab().setCustomView(view2))


        val view3 = layoutInflater.inflate(R.layout.custom_tab, null)
        view3.icon.setBackgroundResource(R.drawable.ic_baseline_circle_black)
        tablayout.addTab(tablayout.newTab().setCustomView(view3))

//        bottom_navigation.setOnNavigationItemSelectedListener{
//            when (it.itemId) {
//                R.id.action_feed -> {
//                    view_pager.currentItem = 0
//                    return@setOnNavigationItemSelectedListener true
//                }
//                R.id.action_event -> {
//                    view_pager.currentItem = 1
//                    return@setOnNavigationItemSelectedListener true
//                }
//                R.id.action_people -> {
//                    view_pager.currentItem = 2
//                    return@setOnNavigationItemSelectedListener true
//                }
//            }
//            return@setOnNavigationItemSelectedListener false
//        }

    }


    private fun createPopupMenu(it: View) {
        val popupMenu = PopupMenu(this, it)
        popupMenu.menuInflater.inflate(R.menu.custom_toolbar, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.logout -> mainActivityPresenter.logout()
            }

            return@setOnMenuItemClickListener true
        }
        popupMenu.show()
    }

    override fun displayUser(user: User) {
        user_name.text = user.name
    }

    override fun logoutSuccessful() {
        showToast("Logout successful")
        launchActivityWithFinish(LoginActivity.createLoginActivity(this))
    }

    override fun logoutFailure() {
        showToast("Something went wrong")
    }

}
