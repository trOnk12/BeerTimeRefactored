package com.example.gebruiker.beertimerefactor.ui.chat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.gebruiker.beertimerefactor.BaseActivity
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.model.Message
import com.stfalcon.chatkit.commons.ImageLoader
import com.stfalcon.chatkit.messages.MessagesListAdapter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_chat.*
import javax.inject.Inject


class ChatActivity : BaseActivity(), ChatAcitivtyView {
    companion object {
        const val EXTRA_DIALOG_ID = "EXTRA_ID"
        const val senderId = "0"

        fun createChatActivity(context: Context, dialogID: String): Intent {
            val intent = Intent(context, ChatActivity::class.java)
            intent.putExtra(ChatActivity.EXTRA_DIALOG_ID, dialogID)
            return intent
        }
    }

    @Inject
    lateinit var presenter: ChatActivityPresenter
    lateinit var chatAdapter: MessagesListAdapter<Message>
    lateinit var dialogID: String

    override fun attachPresenter() {
        presenter.attachView(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        setView()

        presenter.getChatHistory(intent.getStringExtra(EXTRA_DIALOG_ID))
    }

    private fun setView() {

        chatAdapter = MessagesListAdapter(senderId, ImageLoader { imageView, url, payload -> });
        input.setInputListener { input ->
            presenter.addMessage(input, dialogID)
            true
        }

        messagesList.setAdapter(chatAdapter)
    }


    override fun displayChatHistory(messageList: ArrayList<Message>) {
        chatAdapter.addToEnd(messageList, true)
    }

    override fun displayNewMessage(message: Message) {
        chatAdapter.addToStart(message, true)
    }


}