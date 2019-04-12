package com.example.gebruiker.beertimerefactor

import android.content.Intent
import android.support.v4.app.Fragment

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

}