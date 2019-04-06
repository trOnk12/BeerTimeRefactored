package com.example.gebruiker.beertimerefactor.ui.dialogs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.gebruiker.beertimerefactor.BaseActivity
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.model.Dialog
import com.example.gebruiker.beertimerefactor.model.repo.FirebaseRepo
import com.example.gebruiker.beertimerefactor.model.repo.SharedPreferencesRepository
import com.example.gebruiker.beertimerefactor.ui.chat.ChatActivity
import com.stfalcon.chatkit.dialogs.DialogsListAdapter
import javax.inject.Inject

import com.stfalcon.chatkit.commons.ImageLoader
import kotlinx.android.synthetic.main.activity_messages.*
import java.util.*
import kotlin.collections.ArrayList


class DialogsActivity : BaseActivity(), DialogsView {
    companion object {
        fun createDialogsActivityIntent(context: Context): Intent{
            return  Intent(context, DialogsActivity::class.java)
        }
    }

    @Inject
    lateinit var presenter: DialogsActivityPresenter

    private lateinit var dialogsAdapterr: DialogsListAdapter<Dialog>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)

        setUpDialogsAdapter()
        setUpPresenter()

    }

    private fun setUpPresenter() {
        presenter.attachView(this)
        presenter.getUsersDialogs()
    }

    private fun setUpDialogsAdapter() {
        dialogsAdapterr = DialogsListAdapter(ImageLoader { _, _, _ -> })
        dialogsAdapterr.setOnDialogClickListener {
            openChatActivity(it.id)
        }
    }

    override fun displayDialogs(usersDialogs: ArrayList<Dialog>) {
        dialogsAdapterr.setItems(usersDialogs)
        dialogsList.setAdapter(dialogsAdapterr)
    }

     private fun openChatActivity(dialogID: String) {
        val intent = ChatActivity.createChatActivity(this)
        intent.putExtra(ChatActivity.EXTRA_DIALOG_ID,dialogID)

        startActivity(intent)
    }

}