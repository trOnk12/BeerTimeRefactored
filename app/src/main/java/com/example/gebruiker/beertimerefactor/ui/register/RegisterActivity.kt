package com.example.gebruiker.beertimerefactor.ui.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import com.example.gebruiker.beertimerefactor.BaseActivity
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.ui.login.LoginActivity
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

        register_button.setOnClickListener(this)

        presenter.attachView(this)
        presenter.setUpValidationTool(this, R.id.email_et, Patterns.EMAIL_ADDRESS, R.string.err_email)

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
        startActivity(LoginActivity.createLoginActivity(this))
        finish()
    }

}