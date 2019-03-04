package com.example.gebruiker.beertimerefactor.ui.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import com.example.gebruiker.beertimerefactor.BaseActivity
import com.example.gebruiker.beertimerefactor.R
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity : BaseActivity(), RegisterView, View.OnClickListener {
    companion object {
        fun createRegisterActivity(context: Context): Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    @Inject
    lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        presenter.attachView(this)

        setUpValidator()
        setUpListeners()
    }

    private fun setUpListeners() {
        register_button.setOnClickListener(this)
    }


    private fun setUpValidator() {
        presenter.getValidator().addValidation(this, R.id.email_et, Patterns.EMAIL_ADDRESS, R.string.err_email)
    //    presenter.getValidator().addValidation(this, R.id.password_et, regexPassword, R.string.err_password)
     //   presenter.getValidator().addValidation(this, R.id.password_et, R.id.repeat_password_et, R.string.err_password_confirmation);
    }

    override fun onClick(p0: View) {

        when (p0.id) {
            R.id.register_button -> presenter.register(email_et.text.toString(), password_et.text.toString())
            R.id.login_clickable_text -> openLoginActivity()
        }
    }


    override fun registerFailure() {
        showToast("Register failure !")
    }

    override fun registerSuccessFull() {
        showToast("Register succesfull")
        openLoginActivity()
    }


    private fun openLoginActivity() {
        startActivity(RegisterActivity.createRegisterActivity(this))
    }

}