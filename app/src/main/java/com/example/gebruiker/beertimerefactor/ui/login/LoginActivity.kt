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

class LoginActivity : BaseActivity(), View.OnClickListener, LoginActivityView {
companion object {
    fun createLoginActivity(context: Context): Intent {
        return Intent(context, LoginActivity::class.java)
    }
}

    @Inject
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setUpValidator()
        setUpListeners()

        presenter.attachView(this)

    }

    private fun setUpListeners() {
        login_button.setOnClickListener(this)
        login_clickable_text.setOnClickListener(this)
    }

    private fun setUpValidator() {
        presenter.getValidator().addValidation(this, R.id.nickname_input, Patterns.EMAIL_ADDRESS, R.string.err_email)
       // presenter.getValidator().addValidation(this, R.id.password_input, regexPassword, R.string.err_password)
    }

    override fun onClick(view: View) {

        when (view.id) {
            R.id.login_clickable_text -> openRegisterActivity()
            R.id.login_button -> presenter.login(nickname_input.text.toString(), password_input.text.toString())
        }
    }

    private fun openRegisterActivity() {
        startActivity(RegisterActivity.createRegisterActivity(this))
    }

    private fun openMainActivity() {
        startActivity(MainActivity.createMainActivity(this))
    }

    override fun loginSuccessFull() {
        openMainActivity()
        showToast("Login successfull")

    }

    override fun loginFailure() {
        showToast("Login failure")
    }

}