package com.example.gebruiker.beertimerefactor.ui.friends

import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.model.repository.UserRepository

class FriendsListPresenter(var userRepository: UserRepository) : BasePresenter<FriendsListView>() {

    fun getUserFriends(){
        val userFriends: ArrayList<User>? = userRepository.getUserFriends()

        if(userFriends!=null){
            if(userFriends.isNotEmpty()){

                getView().showUserFriends(userFriends)
            }
            else{
                getView().showNoFriendsMessage()
            }
        }
        else{
            getView().showNoFriendsMessage()
        }

    }

}