package com.example.gebruiker.beertimerefactor.di

import android.content.Context
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.gebruiker.beertimerefactor.MyApp
import com.example.gebruiker.beertimerefactor.model.firebase.FireBaseAuthHelper
import com.example.gebruiker.beertimerefactor.model.firebase.FirebaseRepo
import com.example.gebruiker.beertimerefactor.model.repo.local.SharedPreferencesRepository
import com.example.gebruiker.beertimerefactor.model.repo.remote.DialogRepository
import com.example.gebruiker.beertimerefactor.model.repo.remote.EventsRepository
import com.example.gebruiker.beertimerefactor.model.repo.remote.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideSharedPreferencesRepository(context: Context): SharedPreferencesRepository {
        return SharedPreferencesRepository(context)
    }

    @Singleton
    @Provides
    fun provideFireBaseAuthHelper(firebaseRepo: FirebaseRepo, sharedPreferencesRepository: SharedPreferencesRepository): FireBaseAuthHelper {
        return FireBaseAuthHelper(firebaseRepo, sharedPreferencesRepository)
    }

    @Singleton
    @Provides
    fun provideContext(application: MyApp): Context {
        return application
    }


    @Singleton
    @Provides
    fun provideFireBaseRepo(sharedPreferencesRepository: SharedPreferencesRepository): FirebaseRepo {
        return FirebaseRepo(sharedPreferencesRepository)
    }


    @Singleton
    @Provides
    fun provideValidationTool(): AwesomeValidation {
        return AwesomeValidation(ValidationStyle.BASIC)
    }

    @Singleton
    @Provides
    fun provideUserRepository(sharedPreferencesRepository: SharedPreferencesRepository, firebaseRepo: FirebaseRepo): UserRepository {
        return UserRepository(firebaseRepo, sharedPreferencesRepository)
    }


    @Singleton
    @Provides
    fun provideDialogsRepository(sharedPreferencesRepository: SharedPreferencesRepository, firebaseRepo: FirebaseRepo): DialogRepository {
        return DialogRepository(sharedPreferencesRepository, firebaseRepo)
    }


    @Singleton
    @Provides
    fun provideEventsRepository(firebaseRepo: FirebaseRepo): EventsRepository {
        return EventsRepository(firebaseRepo)
    }

}