package com.example.gebruiker.beertimerefactor.ui.register

import com.basgeekball.awesomevalidation.AwesomeValidation
import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.domain.BaseRepositoryContractor
import com.example.gebruiker.beertimerefactor.model.firebase.FireBaseAuthHelper
import com.example.gebruiker.beertimerefactor.model.repository.UserRepository
import com.example.gebruiker.beertimerefactor.model.source.remote.UserRemoteSource

class RegisterPresenter(var userRepository: UserRepository, var validationTool: AwesomeValidation) : BasePresenter<RegisterView>() {

    fun register(email: String, password: String) {
        if (validationTool.validate())
            userRepository.registerUser(email, password, object : BaseRepositoryContractor<Boolean> {
                override fun onDataReceived(data: Boolean) {
                    if(data){
                        getView().registerSuccessFullMessage()
                        getView().launchLoginActivity()
                    }
                }
            })
    }

}