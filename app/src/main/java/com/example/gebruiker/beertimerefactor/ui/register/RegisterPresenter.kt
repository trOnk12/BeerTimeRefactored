package com.example.gebruiker.beertimerefactor.ui.register

import com.basgeekball.awesomevalidation.AwesomeValidation
import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.domain.IBaseRepository

import com.example.gebruiker.beertimerefactor.model.repository.UserRepository

class RegisterPresenter(var userRepository: UserRepository, var validationTool: AwesomeValidation) : BasePresenter<RegisterView>() {

    fun register(email: String, password: String) {
        getView().isLoading(true)
            userRepository.registerUser(email, password, object : IBaseRepository<Boolean> {
                override fun onDataReceived(data: Boolean) {
                    if(data){
                        getView().isLoading(false)
                        getView().registrationSuccessful()
                    }
                }
            })
    }

}