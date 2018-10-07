package com.example.gebruiker.beertimerefactor.ui.login

import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.FireBaseAuthHelper

class LoginPresenter(var loginActivity: LoginActivity, var fireBaseAuthHelper: FireBaseAuthHelper) : BasePresenter<LoginActivity>() {

    fun login(email: String, password: String) {

        if (fireBaseAuthHelper.validateLogin(loginActivity)) {
            fireBaseAuthHelper.loginUser(loginActivity, email, password, object : FireBaseAuthHelper.CallBackListener {

                override fun success() {
                    getView().loginSuccessFull()
                }

                override fun error() {
                    getView().loginFailure()
                }
            })
        }
    }

}