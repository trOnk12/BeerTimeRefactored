package com.example.gebruiker.beertimerefactor.ui.register

import android.app.Activity
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.firebase.FireBaseAuthHelper
import com.example.gebruiker.beertimerefactor.model.source.remote.UserRemoteSource
import java.util.regex.Pattern

class RegisterPresenter(var userRemoteSource: UserRemoteSource, var validationTool: AwesomeValidation) : BasePresenter<RegisterView>() {

    fun register(email: String, password: String) {

        if (validationTool.validate())
            userRemoteSource.registerUser(email, password, object : FireBaseAuthHelper.CallBackListener {
                override fun success() {
                    getView().registerSuccessFull()
                }

                override fun error() {
                    getView().registerFailure()
                }

            })
    }

}