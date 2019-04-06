package com.example.gebruiker.beertimerefactor.ui.dialogs.di

import com.example.gebruiker.beertimerefactor.model.repo.DialogRepository
import com.example.gebruiker.beertimerefactor.model.repo.FirebaseRepo
import com.example.gebruiker.beertimerefactor.model.repo.SharedPreferencesRepository
import com.example.gebruiker.beertimerefactor.ui.dialogs.DialogsActivityPresenter
import dagger.Module
import dagger.Provides


@Module
class DialogsActivityModule {

    @Provides
    fun provideDialogsActivityPresenter(dialogsRepository: DialogRepository): DialogsActivityPresenter {
        return DialogsActivityPresenter(dialogsRepository)
    }



}