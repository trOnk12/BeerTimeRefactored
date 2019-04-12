package com.example.gebruiker.beertimerefactor.ui.chat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.model.Message
import com.stfalcon.chatkit.commons.ImageLoader
import com.stfalcon.chatkit.messages.MessagesListAdapter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_chat.*
import javax.inject.Inject
import com.stfalcon.chatkit.messages.MessageInput


class ChatActivity : DaggerAppCompatActivity(), ChatAcitivtyView {
    companion object {
        const val EXTRA_DIALOG_ID = "EXTRA_ID"
        const val senderId = "0"

        fun createChatActivity(context: Context): Intent {
            return Intent(context, ChatActivity::class.java)
        }
    }

    lateinit var dialogID: String

    @Inject
    lateinit var presenter: ChatActivityPresenter

    lateinit var chatAdapter: MessagesListAdapter<Message>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        chatAdapter = MessagesListAdapter(senderId, ImageLoader { imageView, url, payload -> });
        input.setInputListener { input ->
            presenter.addMessage(input, dialogID)
            true
        }

        messagesList.setAdapter(chatAdapter)

        presenter.attachView(this)
        presenter.getChatHistory(intent.getStringExtra(EXTRA_DIALOG_ID))
    }


    override fun displayChatHistory(messageList: ArrayList<Message>) {
        chatAdapter.addToEnd(messageList, true)
    }

    override fun displayNewMessage(message: Message) {
        chatAdapter.addToStart(message, true)
    }


}