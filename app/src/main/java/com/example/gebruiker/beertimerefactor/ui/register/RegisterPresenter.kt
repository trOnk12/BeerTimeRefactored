package com.example.gebruiker.beertimerefactor.ui.register

import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.FireBaseAuthHelper

class RegisterPresenter(var registerActivity: RegisterActivity,var fireBaseAuthHelper: FireBaseAuthHelper) : BasePresenter<RegisterView>() {

    var mAwesomeValidation = AwesomeValidation(ValidationStyle.BASIC)

    fun register(email:String,password:String){

        if (validateCredentials()) {
            fireBaseAuthHelper.registerUser(email, password, object : FireBaseAuthHelper.CallBackListener {

                override fun success() {
                    getView().loginSuccessFull()
                }

                override fun error() {
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