package com.example.gebruiker.beertimerefactor.ui.login

import com.basgeekball.awesomevalidation.AwesomeValidation
import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.firebase.FireBaseAuthHelper
import com.example.gebruiker.beertimerefactor.model.source.remote.UserRemoteSource

class LoginPresenter(private var userRemoteSource: UserRemoteSource, var validationTool: AwesomeValidation) : BasePresenter<LoginActivityView>() {

    fun login(email: String, password: String) {

        if (validationTool.validate())
            userRemoteSource.loginUser(email, password, object : FireBaseAuthHelper.CallBackListener {
                override fun success() {
                    getView().loginSuccessFullMessage()
                    getView().launchMainActivity()
                }

                override fun error() {
                    getView().loginFailureMessage()
                }

            })
    }


}