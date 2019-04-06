package com.example.gebruiker.beertimerefactor.ui.register

import android.app.Activity
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.repo.FireBaseAuthHelper
import com.example.gebruiker.beertimerefactor.model.repo.UserRepository
import java.util.regex.Pattern

class RegisterPresenter(var userRepository: UserRepository, var validationTool: AwesomeValidation) : BasePresenter<RegisterView>() {

    fun register(email: String, password: String) {

        if (validationTool.validate())
            userRepository.register(email, password, object : FireBaseAuthHelper.CallBackListener {
                override fun success() {

                }

                override fun error() {

                }

            })
    }


    fun setUpValidationTool(registerActrivity: Activity, email_address: Int, emaiL_ADDRESS: Pattern?, err_email: Int) {
        validationTool.addValidation(registerActrivity, email_address, emaiL_ADDRESS, err_email)
    }

}