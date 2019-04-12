package com.example.gebruiker.beertimerefactor.ui.map.di

import com.example.gebruiker.beertimerefactor.model.source.remote.EventsRepository
import com.example.gebruiker.beertimerefactor.ui.map.MapsPresenter
import dagger.Module
import dagger.Provides

@Module
class MapModule {

    @Provides
    fun providePresenter(eventsRepository: EventsRepository) : MapsPresenter {
        return MapsPresenter(eventsRepository)
    }

}