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

class RegisterActivity : BaseActivity(), RegisterView {
    companion object {
        fun createRegisterActivity(context: Context): Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    @Inject
    lateinit var presenter: RegisterPresenter

    override fun attachPresenter() {
        presenter.attachView(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setView()
    }

    private fun setView() {
        presenter.validationTool.addValidation(this, R.id.email_et, Patterns.EMAIL_ADDRESS, R.string.err_email)

        login_clickable_text.setOnClickListener { startActivity(LoginActivity.createLoginActivity(this)) }
        register_button.setOnClickListener { presenter.register(email_et.text.toString(), password_et.text.toString()) }
    }

    override fun isLoading(isLoading: Boolean) {
        if (isLoading) {
            loading.visibility = View.VISIBLE
        } else {
            loading.visibility = View.GONE
        }
    }

    override fun registrationSuccessful() {
        showToast("Registration successful")
        startActivity(LoginActivity.createLoginActivity(this))
    }



}