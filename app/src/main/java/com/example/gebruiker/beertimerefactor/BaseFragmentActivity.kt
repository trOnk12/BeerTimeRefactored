package com.example.gebruiker.beertimerefactor

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.gebruiker.beertimerefactor.ui.main.fragments.EventsMainFragment
import com.example.gebruiker.beertimerefactor.ui.main.fragments.FeedMainFragment
import com.example.gebruiker.beertimerefactor.ui.main.fragments.PeopleMainFragment

open class BaseFragmentActivity: BaseToolBarActivity() {

     fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left)
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    fun launchActivityWithFinish(intent: Intent){
        launchActivityWithFinish(intent)
        finish()
    }

     inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = 3

        override fun getItem(position: Int): Fragment? {

            var fragment: Fragment? = null

            when (position) {
                0 -> fragment = FeedMainFragment.newInstance()
                1 -> fragment = EventsMainFragment.newInstance()
                2 -> fragment = PeopleMainFragment.newInstance()
            }

            return fragment
        }
    }
}