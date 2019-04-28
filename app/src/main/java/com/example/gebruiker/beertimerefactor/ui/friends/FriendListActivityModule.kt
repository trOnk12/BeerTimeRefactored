package com.example.gebruiker.beertimerefactor.ui.friends

import com.example.gebruiker.beertimerefactor.model.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class FriendListActivityModule {

    @Provides
    fun provideFriendListPresenter(userRepository: UserRepository): FriendsListPresenter {
        return FriendsListPresenter(userRepository)
    }

}