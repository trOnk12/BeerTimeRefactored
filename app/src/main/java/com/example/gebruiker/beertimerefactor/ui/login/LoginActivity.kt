package com.example.gebruiker.beertimerefactor.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import com.example.gebruiker.beertimerefactor.BaseActivity
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.ui.main.MainActivity
import com.example.gebruiker.beertimerefactor.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(),LoginActivityView {
    companion object {
        fun createLoginActivity(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    @Inject
    lateinit var presenter: LoginPresenter

    override fun attachPresenter() {
        presenter.attachView(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setView()
    }

    private fun setView() {
        presenter.validationTool.addValidation(this, R.id.email_input, Patterns.EMAIL_ADDRESS, R.string.err_email)
        login_clickable_text.setOnClickListener{ startActivity(RegisterActivity.createRegisterActivity(this)) }
        login_button.setOnClickListener{ presenter.login(email_input.text.toString(),password_input.text.toString()) }
    }

    override fun isLoading(isLoading: Boolean) {
        if(isLoading){
            progressBar.visibility=View.VISIBLE
        }
        else{
            progressBar.visibility=View.GONE
        }
    }

    override fun loginSuccessFull() {
        showToast(getString(R.string.login_success))
        startActivity(MainActivity.createMainActivity(this))
    }


}