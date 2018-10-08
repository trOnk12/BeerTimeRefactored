package com.example.gebruiker.beertimerefactor.di

import android.content.Context
import com.example.gebruiker.beertimerefactor.MyApp
import com.example.gebruiker.beertimerefactor.model.FireBaseAuthHelper
import com.example.gebruiker.beertimerefactor.model.SharedPreferencesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideSharedPreferencesRepository(context: Context) : SharedPreferencesRepository{
        return SharedPreferencesRepository(context)
    }

    @Singleton
    @Provides
    fun provideFireBaseAuthHelper(sharedPreferencesRepository: SharedPreferencesRepository) : FireBaseAuthHelper {
        return FireBaseAuthHelper(sharedPreferencesRepository)
    }

    @Singleton
    @Provides
    fun provideContext(application: MyApp): Context {
        return application
    }

}