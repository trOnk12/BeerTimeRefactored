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


class DialogsActivity : BaseActivity(), DialogsView {
    companion object {
        fun createDialogsActivityIntent(context: Context): Intent{
            return  Intent(context, DialogsActivity::class.java)
        }
    }

    @Inject
    lateinit var presenter: DialogsActivityPresenter

    @Inject
    lateinit var  firebaseRepo: FirebaseRepo

    @Inject
    lateinit var sharedPreferencesRepository: SharedPreferencesRepository

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

//            val message = Message()
//            val user = User()
//            user.id= sharedPreferencesRepository.getUser()!!.id
//            user.name = "trOnk12"
//            user.avatar= "null"
//
//            message.setUser(user)
//
//            val date = Date()
//            date.time = System.currentTimeMillis()
//            message.setCreaedAt(date)
//            message.text = "DUPA JASIA TEST"
//            message.id = firebaseRepo.fireBaseDataBase.reference.push().key
//
//
//            firebaseRepo.addMessage(it.id,message)
          //  presenter.openDialogMessages(it.id)

            openChatActivity(it.id)
        }

    }

    override fun displayViews(list: ArrayList<Dialog>) {
        dialogsAdapterr.setItems(list)
        dialogsList.setAdapter(dialogsAdapterr)
    }

     private fun openChatActivity(dialogID: String) {
        val intent = ChatActivity.createChatActivity(this)
        intent.putExtra(ChatActivity.EXTRA_DIALOG_ID,dialogID)

        startActivity(intent)
    }


}