package com.example.gebruiker.beertimerefactor.ui.dialogs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.gebruiker.beertimerefactor.BaseActivity
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.model.Dialog
import com.example.gebruiker.beertimerefactor.ui.chat.ChatActivity
import com.stfalcon.chatkit.dialogs.DialogsListAdapter
import javax.inject.Inject

import com.stfalcon.chatkit.commons.ImageLoader
import kotlinx.android.synthetic.main.activity_messages.*
import kotlin.collections.ArrayList


class DialogsActivity : BaseActivity(), DialogsView {
    companion object {
        fun createDialogsActivityIntent(context: Context): Intent {
            return Intent(context, DialogsActivity::class.java)
        }
    }

    @Inject
    lateinit var presenter: DialogsActivityPresenter
    private lateinit var dialogsAdapter: DialogsListAdapter<Dialog>

    override fun attachPresenter() {
        presenter.attachView(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)

        dialogsAdapter = DialogsListAdapter(ImageLoader { _, _, _ -> })
        dialogsAdapter.setOnDialogClickListener {
            startActivity(ChatActivity.createChatActivity(this, it.id))
        }
        presenter.getUsersDialogs()
    }

    override fun displayDialogs(usersDialogs: ArrayList<Dialog>) {
        dialogsAdapter.setItems(usersDialogs)
        dialogsList.setAdapter(dialogsAdapter)
    }

}