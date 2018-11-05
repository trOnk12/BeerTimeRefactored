package com.example.gebruiker.beertimerefactor.ui.messages

import android.os.Bundle
import com.example.gebruiker.beertimerefactor.BaseActivity
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.model.Dialog
import com.example.gebruiker.beertimerefactor.model.Message
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.model.repo.FirebaseRepo
import com.example.gebruiker.beertimerefactor.model.repo.SharedPreferencesRepository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.GenericTypeIndicator
import com.google.firebase.database.ValueEventListener
import com.stfalcon.chatkit.commons.ImageLoader
import com.stfalcon.chatkit.dialogs.DialogsList
import com.stfalcon.chatkit.dialogs.DialogsListAdapter
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class MessagesActivity : BaseActivity() {

    @Inject
    lateinit var firebaseRepo: FirebaseRepo

    @Inject
    lateinit var sharedPreferencesRepository: SharedPreferencesRepository

    lateinit var dialogList: ArrayList<Dialog>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)

        android.util.Log.d("TEST", "id " + sharedPreferencesRepository.getUser())

        val user1 = User()
        user1.avatar = ""
        user1.name = "trOnk12"
        user1.id = sharedPreferencesRepository.getUser()!!

      //  firebaseRepo.addUser(user1)

        val user2 = User()
        user2.avatar = ""
        user2.name = "Jurek Owsiak"
        user2.id = "TEST ID"

        val dialog = Dialog()
        dialog.id = firebaseRepo.fireBaseDataBase.reference.push().key
        dialog.dialogPhoto = ""
        dialog.dialogName = "test"
       // dialog.users = arrayListOf(user1, user2)

        //  dialog.lastMessage = null
        //dialog.setUnreadcount(2)

    //    firebaseRepo.addDialog(dialog)

        val dialogsAdapter: DialogsListAdapter<Dialog>

        firebaseRepo.getDialogs(object : ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {
            android.util.Log.d("TEST","error" + p0.code +p0.details)
            }

            override fun onDataChange(p0: DataSnapshot) {


                android.util.Log.d("TEST", "" + p0.children)

                val t = object : GenericTypeIndicator<HashMap<String,Message>>() {

                }

                val messages = p0.getValue(t)!!.toList()


               android.util.Log.d("TEST","" +
                       messages.get(1) )


//                p0.children.forEach{ android.util.Log.d("TEST", "test" + it.value )
//
//                var dialog = it.getValue() as Dialog
//
//                    android.util.Log.d("TEST", "" + dialog.dialogName)
//
//
//
//                }
//
            }

        })

//        val dialogsListAdapter = DialogsListAdapter(dialogs, ImageLoader { imageView, url, payload ->
//
//        })


    }
}