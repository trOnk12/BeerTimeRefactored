package com.example.gebruiker.beertimerefactor.ui.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.ui.login.LoginActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity : DaggerAppCompatActivity(),RegisterView,View.OnClickListener {

    @Inject
    lateinit var  presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        register_button.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        presenter.register(email_et.text.toString(),password_et.text.toString())
    }

    override fun loginFailure() {
        Toast.makeText(this,"Ooops, something went wrong.", Toast.LENGTH_LONG).show()
    }

    override fun loginSuccessFull() {
       Toast.makeText(this,"Your account has been created.", Toast.LENGTH_LONG).show()
        openLoginActivity()
    }

    private fun openLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

}