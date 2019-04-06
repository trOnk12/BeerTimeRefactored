package com.example.gebruiker.beertimerefactor.ui.login

import android.app.Activity
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.repo.FireBaseAuthHelper
import com.example.gebruiker.beertimerefactor.model.repo.UserRepository
import java.util.regex.Pattern

class LoginPresenter(private var userRepository: UserRepository, var validationTool: AwesomeValidation) : BasePresenter<LoginActivityView>() {

    fun setUpValidationTool(loginActivity: Activity, nickname_input: Int, emaiL_ADDRESS: Pattern?, err_email: Int) {
        validationTool.addValidation(loginActivity, nickname_input, emaiL_ADDRESS, err_email)
    }

    fun login(email: String, password: String) {

        if (validationTool.validate())
            userRepository.loginUser(email, password, object : FireBaseAuthHelper.CallBackListener {
                override fun success() {
                    getView().loginSuccessFull()
                }

                override fun error() {
                    getView().loginFailure()
                }

            })
    }


}