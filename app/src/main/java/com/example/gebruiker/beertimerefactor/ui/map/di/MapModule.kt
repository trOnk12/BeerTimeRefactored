package com.example.gebruiker.beertimerefactor.ui.map.di

import com.example.gebruiker.beertimerefactor.model.repo.FireBaseAuthHelper
import com.example.gebruiker.beertimerefactor.model.repo.FirebaseRepo
import com.example.gebruiker.beertimerefactor.ui.login.LoginPresenter
import com.example.gebruiker.beertimerefactor.ui.map.MapsPresenter
import dagger.Module
import dagger.Provides

@Module
class MapModule {

    @Provides
    fun providePresenter(firebaseRepo: FirebaseRepo) : MapsPresenter {
        return MapsPresenter(firebaseRepo)
    }

}