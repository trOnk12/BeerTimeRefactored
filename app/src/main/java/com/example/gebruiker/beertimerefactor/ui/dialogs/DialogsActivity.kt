package com.example.gebruiker.beertimerefactor.ui.dialogs

import android.os.Bundle
import android.widget.ImageView
import com.example.gebruiker.beertimerefactor.BaseActivity
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.model.Dialog
import com.example.gebruiker.beertimerefactor.model.Message
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.model.repo.FirebaseRepo
import com.example.gebruiker.beertimerefactor.model.repo.SharedPreferencesRepository
import com.example.gebruiker.beertimerefactor.ui.chat.ChatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.stfalcon.chatkit.dialogs.DialogsListAdapter
import javax.inject.Inject

import com.stfalcon.chatkit.commons.ImageLoader
import kotlinx.android.synthetic.main.activity_messages.*


class DialogsActivity : BaseActivity(), DialogsView {

    @Inject
    lateinit var presenter: DialogsActivityPresenter

    lateinit var dialogsAdapterr: DialogsListAdapter<Dialog>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)
        init()

        presenter.getDialogsForUser()

    }

    private fun init() {

        presenter.attachView(this)
        dialogsAdapterr = DialogsListAdapter(ImageLoader { imageView, url, payload -> })

        dialogsAdapterr.setOnDialogClickListener {

//            val user1 = User()
//            user1.avatar = ""
//            user1.name = "trOnk12"
//            //  user1.id = sharedPreferencesRepository.getUser()!!.id
//
//            //  firebaseRepo.addUser(user1)
//
//            val user2 = User()
//            user2.avatar = ""
//            user2.name = "Jurek Owsiak"
//            user2.id = "TEST ID"
//
//
//            val message = Message()
//            message.setUser(user1)
//            message.id = firebaseRepo.fireBaseDataBase.reference.push().key
//            message.text= "Lorem ipsum."
//
//            firebaseRepo.addMessage(it.id,message)

            presenter.openDialogMessages(it.id)
        }


    }

    override fun displayViews(list: ArrayList<Dialog>) {
        dialogsAdapterr.setItems(list)
        dialogsList.setAdapter(dialogsAdapterr)
    }

    override fun openChatActivity(messageList: ArrayList<Message>) {
      val intent = ChatActivity.createChatActivity(this)
        intent.putExtra(ChatActivity.MESSAGES, messageList)
    }


}