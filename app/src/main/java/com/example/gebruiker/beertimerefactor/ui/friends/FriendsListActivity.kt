package com.example.gebruiker.beertimerefactor.ui.friends

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.gebruiker.beertimerefactor.BaseActivity
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.model.User
import javax.inject.Inject

class FriendsListActivity : BaseActivity(),FriendsListView {
    companion object {
        fun createFriendListIntent(context: Context): Intent {
            return Intent(context,FriendsListActivity::class.java)
        }
    }

    @Inject
    lateinit var friendsListPresenter:FriendsListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends_list)
        setView()

        friendsListPresenter.getUserFriends()
    }

    private fun setView() {

    }

    override fun attachPresenter() {
        friendsListPresenter.attachView(this)
    }

    override fun showUserFriends(userFriends: ArrayList<User>?) {

    }

    override fun showNoFriendsMessage() {

    }

}