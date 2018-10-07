package com.example.gebruiker.beertimerefactor.di

import android.app.Application
import android.content.Context
import com.example.gebruiker.beertimerefactor.MyApp
import com.example.gebruiker.beertimerefactor.model.FireBaseAuthHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideFireBaseAuthHelper(context : Context) : FireBaseAuthHelper {
        return FireBaseAuthHelper(context)
    }

    @Singleton
    @Provides
    fun provideContext(application: MyApp): Context {
        return application
    }

}