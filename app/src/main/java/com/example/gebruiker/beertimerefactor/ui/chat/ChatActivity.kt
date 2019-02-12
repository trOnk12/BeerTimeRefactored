package com.example.gebruiker.beertimerefactor.ui.chat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Message
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.ui.main.MainActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class ChatActivity : DaggerAppCompatActivity() {
    companion object {
        const val MESSAGES = "EXTRA_MESSAGES"

        fun createChatActivity(context: Context): Intent {
            return Intent(context, ChatActivity::class.java)
        }
    }

    @Inject
    lateinit var presenter: ChatActivityPresenter

    lateinit var extraMessages : ArrayList<Message>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        init()

        retrieveExtraMessages()
        presenter.getMessages()

    }

    private fun retrieveExtraMessages() {
        extraMessages = intent.getSerializableExtra(MESSAGES) as ArrayList<Message>
    }

    private fun init() {

    }

}