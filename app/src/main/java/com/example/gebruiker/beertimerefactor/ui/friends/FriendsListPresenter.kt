package com.example.gebruiker.beertimerefactor.ui.friends

import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.model.repository.UserRepository
import com.example.gebruiker.beertimerefactor.model.source.remote.UserRemoteSource

class FriendsListPresenter(var userRepository: UserRepository) : BasePresenter<FriendsListView>() {

    fun getUserFriends() {
        getView().isLoading(true)
        userRepository.getUserFriends(object : UserRemoteSource.UserFriendsListener {
            override fun onUserFriendsRetrieved(friendList: ArrayList<User>) {
                if (friendList.isNotEmpty()) {
                    getView().isLoading(false)
                    getView().showUserFriends(friendList)
                } else {
                    getView().showNoFriendsMessage()
                }
            }
        })
    }

}