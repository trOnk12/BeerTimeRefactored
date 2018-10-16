package com.example.gebruiker.beertimerefactor.ui.register

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.ui.ValidatorHelper.Companion.regexPassword
import com.example.gebruiker.beertimerefactor.ui.login.LoginActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity : DaggerAppCompatActivity(), RegisterView, View.OnClickListener {

    @Inject
    lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setUpValidator()
        setUpListeners()

        presenter.attachView(this)

    }

    private fun setUpListeners() {

        register_button.setOnClickListener(this)
    }


    private fun setUpValidator() {

        presenter.getValidator().addValidation(this, R.id.email_et, Patterns.EMAIL_ADDRESS, R.string.err_email)
        presenter.getValidator().addValidation(this, R.id.password_et, regexPassword, R.string.err_password)
        presenter.getValidator().addValidation(this, R.id.password_et, R.id.repeat_password_et, R.string.err_password_confirmation);

    }

    override fun onClick(p0: View) {

        when (p0.id) {
            R.id.register_button -> presenter.register(email_et.text.toString(), password_et.text.toString())
            R.id.login_clickable_text -> openLoginActivity()

        }
    }

    private fun openLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }


    override fun registerFailure() {
        showRegisterFailureToast()
    }

    private fun showRegisterFailureToast() {
        Toast.makeText(this, "Ooops, something went wrong !", Toast.LENGTH_LONG).show()
    }

    override fun registerSuccessFull() {
        showRegisterSuccesFull()
        openLoginActivity()
    }

    private fun showRegisterSuccesFull() {
        Toast.makeText(this, "Your account has been created.", Toast.LENGTH_LONG).show()
    }


}