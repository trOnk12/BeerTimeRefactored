package com.example.gebruiker.beertimerefactor.ui.friends

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.gebruiker.beertimerefactor.BaseActivity
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.ui.chat.ChatActivity
import com.example.gebruiker.beertimerefactor.ui.event.viewholder.ParticipantsAdapter
import kotlinx.android.synthetic.main.activity_friends_list.*
import kotlinx.android.synthetic.main.activity_messages.*
import kotlinx.android.synthetic.main.custom_chat_toolbar.view.*
import kotlinx.android.synthetic.main.fragment_event_description.*
import kotlinx.android.synthetic.main.horizontal_recycyler_view.view.*
import javax.inject.Inject

class FriendsListActivity : BaseActivity(),FriendsListView, FriendsListAdapter.onItemClickListener {
    companion object {
        fun createFriendListIntent(context: Context): Intent {
            return Intent(context,FriendsListActivity::class.java)
        }
    }

    @Inject
    lateinit var friendsListPresenter:FriendsListPresenter

    private val adapter = FriendsListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends_list)
        setView()

        friendsListPresenter.getUserFriends()
    }

    private fun setView() {
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        friend_list.layoutManager = linearLayoutManager
        friend_list.setHasFixedSize(true)
    }

    override fun attachPresenter() {
        friendsListPresenter.attachView(this)
    }

    override fun showUserFriends(userFriends: ArrayList<User>?) {
        adapter.friendsList= userFriends!!
        friend_list.adapter=adapter
        adapter.notifyDataSetChanged()
    }

    override fun showNoFriendsMessage() {

    }

    override fun isLoading(b: Boolean) {
     if(b){
         progressBar2.visibility= View.VISIBLE
     }
        else{
         progressBar2.visibility= View.GONE
     }
    }


    override fun onItemClick(user: User) {

    }

}