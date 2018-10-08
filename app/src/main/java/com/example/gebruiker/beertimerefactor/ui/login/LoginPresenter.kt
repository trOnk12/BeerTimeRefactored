package com.example.gebruiker.beertimerefactor.ui.login

import android.util.Patterns
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.FireBaseAuthHelper
import com.example.gebruiker.beertimerefactor.ui.ValidatorHelper.Companion.regexPassword
import javax.inject.Inject

class LoginPresenter(private var fireBaseAuthHelper: FireBaseAuthHelper) : BasePresenter<LoginActivityView>() {

    private var mAwesomeValidation = AwesomeValidation(ValidationStyle.BASIC)

    private var UserLoggedIn: Boolean? = null

    fun loggedIn(): Boolean? {
        return UserLoggedIn
    }

    fun login(email: String, password: String){

        if (validateCredentials()) {
            fireBaseAuthHelper.loginUser(email, password, object : FireBaseAuthHelper.CallBackListener {

                override fun success() {
                    UserLoggedIn = true
                    getView().loginSuccessFull()
                }

                override fun error() {
                    UserLoggedIn = false
                    getView().loginFailure()
                }
            })
        }
    }


    fun getValidator(): AwesomeValidation {
        return mAwesomeValidation
    }

    private fun validateCredentials(): Boolean {
        return mAwesomeValidation.validate()
    }

}