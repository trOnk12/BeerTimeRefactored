package com.example.gebruiker.beertimerefactor.ui.login

import com.basgeekball.awesomevalidation.AwesomeValidation
import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.domain.IBaseRepository
import com.example.gebruiker.beertimerefactor.model.repository.IUserRepository

class LoginPresenter(var userRepository: IUserRepository, var validationTool: AwesomeValidation) : BasePresenter<LoginActivityView>() {

    fun login(email: String, password: String) {

        if (validationTool.validate())
            userRepository.loginUser(email, password, object : IBaseRepository<Boolean> {

                override fun onDataReceived(data: Boolean) {
                    if (data) {
                        getView().loginSuccessFullMessage()
                        getView().launchMainActivity()
                    }
                }
            })
    }


}