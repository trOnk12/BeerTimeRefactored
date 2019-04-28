package com.example.gebruiker.beertimerefactor.ui.friends

import com.example.gebruiker.beertimerefactor.baseMVP.BaseView
import com.example.gebruiker.beertimerefactor.model.User

interface FriendsListView : BaseView {
    fun showUserFriends(userFriends: ArrayList<User>?)
    fun showNoFriendsMessage()
}