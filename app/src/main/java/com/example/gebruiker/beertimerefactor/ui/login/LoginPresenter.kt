package com.example.gebruiker.beertimerefactor.ui.login

import com.basgeekball.awesomevalidation.AwesomeValidation
import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.domain.BaseRepositoryContractor
import com.example.gebruiker.beertimerefactor.model.firebase.FireBaseAuthHelper
import com.example.gebruiker.beertimerefactor.model.repository.UserRepository
import com.example.gebruiker.beertimerefactor.model.source.remote.UserRemoteSource

class LoginPresenter(var userRepository: UserRepository, var validationTool: AwesomeValidation) : BasePresenter<LoginActivityView>() {

    fun login(email: String, password: String) {

        if (validationTool.validate())
            userRepository.loginUser(email, password, object : BaseRepositoryContractor<Boolean> {

                override fun onDataReceived(data: Boolean) {
                    if (data) {
                        getView().loginSuccessFullMessage()
                        getView().launchMainActivity()
                    }
                }
            })
    }


}