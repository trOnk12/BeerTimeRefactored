package com.example.gebruiker.beertimerefactor.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.ui.ValidatorHelper.Companion.regexPassword
import com.example.gebruiker.beertimerefactor.ui.register.RegisterActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity(), View.OnClickListener, LoginActivityView {

    @Inject
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setUpValidator()

        login_button.setOnClickListener(this)
        login_clickable_text.setOnClickListener(this)

        presenter.attachView(this)

    }

    private fun setUpValidator() {

        presenter.getValidator().addValidation(this, R.id.nickname_input, Patterns.EMAIL_ADDRESS, R.string.err_email)
        presenter.getValidator().addValidation(this, R.id.password_input, regexPassword, R.string.err_password)

    }

    override fun onClick(view: View) {

            when (view.id) {
                R.id.login_clickable_text -> openRegisterActivity()
                R.id.login_button ->  presenter.login(nickname_input.text.toString(),password_input.text.toString())
            }
    }

    private fun openRegisterActivity() {

        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)

    }

    override fun loginSuccessFull() {
        Toast.makeText(this,"Login succeed",Toast.LENGTH_LONG).show()
    }

    override fun loginFailure() {
       Toast.makeText(this,"Login failure",Toast.LENGTH_SHORT).show()
    }

}