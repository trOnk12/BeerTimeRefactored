package com.example.gebruiker.beertimerefactor.ui.register

import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.FireBaseAuthHelper

class RegisterPresenter(var registerActivity: RegisterActivity,var fireBaseAuthHelper: FireBaseAuthHelper) : BasePresenter<RegisterView>() {
    init{
        attachView(registerActivity)
    }

    fun register(email:String,password:String){

        if(fireBaseAuthHelper.validateRegister(registerActivity)) {
            fireBaseAuthHelper.registerUser(registerActivity, email, password, object : FireBaseAuthHelper.CallBackListener {

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