package com.example.gebruiker.beertimerefactor.ui.dialogs

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.view.View
import com.example.gebruiker.beertimerefactor.BaseActivity
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.R.id.dialogsList
import com.example.gebruiker.beertimerefactor.R.id.empty_inbox_message
import com.example.gebruiker.beertimerefactor.model.Dialog
import com.example.gebruiker.beertimerefactor.ui.chat.ChatActivity
import com.example.gebruiker.beertimerefactor.ui.friends.FriendsListActivity
import com.google.android.libraries.places.internal.it
import com.stfalcon.chatkit.dialogs.DialogsListAdapter
import javax.inject.Inject

import com.stfalcon.chatkit.commons.ImageLoader
import kotlinx.android.synthetic.main.activity_messages.*
import kotlinx.android.synthetic.main.custom_chat_toolbar.view.*
import kotlinx.android.synthetic.main.custom_toolbar_.view.*
import kotlin.collections.ArrayList

class DialogsActivity : BaseActivity(), DialogsView {
    companion object {
        fun createDialogsActivityIntent(context: Context): Intent {
            return Intent(context, DialogsActivity::class.java)
        }
    }

    @Inject
    lateinit var presenter: DialogsActivityPresenter
    private lateinit var dialogsListAdapter: DialogsListAdapter<Dialog>

    override fun attachPresenter() {
        presenter.attachView(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)
        setView()

        presenter.getUsersDialogs()
    }

    private fun setView() {
        message_toolbar_container.chat_toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back_white_24dp)
        message_toolbar_container.chat_toolbar.title = ""
        setSupportActionBar(message_toolbar_container.chat_toolbar)

        dialogsListAdapter = DialogsListAdapter(ImageLoader { _, _, _ -> })
        dialogsListAdapter.setOnDialogClickListener { dialog ->
            startActivity(ChatActivity.createChatActivity(this, dialog.id))
        }

        new_message_button.setOnClickListener { startActivity(FriendsListActivity.createFriendListIntent(this)) }

    }

    override fun displayDialogs(usersDialogs: ArrayList<Dialog>?) {
        dialogsListAdapter.setItems(usersDialogs)
        dialogsList.setAdapter(dialogsListAdapter)
    }

    override fun emptyInboxMessage() {
        dialogsList.visibility = View.GONE
        empty_inbox_message.visibility = View.VISIBLE
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}