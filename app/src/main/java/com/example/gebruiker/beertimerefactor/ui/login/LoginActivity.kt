package com.example.gebruiker.beertimerefactor.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.gebruiker.beertimerefactor.BaseActivity
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.R.string.err_email
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

        presenter.validationTool.addValidation(this, R.id.nickname_input, Patterns.EMAIL_ADDRESS, R.string.err_email)

        login_button.setOnClickListener{ presenter.login(nickname_input.text.toString(),password_input.text.toString()) }
        login_clickable_text.setOnClickListener{ launchActivityWithFinish(RegisterActivity.createRegisterActivity(this)) }
    }

    override fun loginSuccessFullMessage() {
        showToast(getString(R.string.login_success))
    }

    override fun loginFailureMessage(error: String) {
        showToast(error)
    }

    override fun launchMainActivity() {
        launchActivityWithFinish(MainActivity.createMainActivity(this))
    }

}