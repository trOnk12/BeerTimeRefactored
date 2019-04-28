package com.example.gebruiker.beertimerefactor.di

import android.content.Context
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.gebruiker.beertimerefactor.MyApp
import com.example.gebruiker.beertimerefactor.model.firebase.FireBaseAuthHelper
import com.example.gebruiker.beertimerefactor.model.firebase.FirebaseRepo
import com.example.gebruiker.beertimerefactor.model.repository.ChatRepository
import com.example.gebruiker.beertimerefactor.model.repository.UserRepository
import com.example.gebruiker.beertimerefactor.model.source.local.ChatCachedSource
import com.example.gebruiker.beertimerefactor.model.source.local.UserCachedSource
import com.example.gebruiker.beertimerefactor.model.source.remote.ChatRemoteSource
import com.example.gebruiker.beertimerefactor.model.source.remote.DialogRepository
import com.example.gebruiker.beertimerefactor.model.source.remote.EventsRepository
import com.example.gebruiker.beertimerefactor.model.source.remote.UserRemoteSource
import com.example.gebruiker.beertimerefactor.util.SharedPreferencesManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {


    @Singleton
    @Provides
    fun provideSharedPreferencesManager(context:Context):SharedPreferencesManager{
        return SharedPreferencesManager(context)
    }

    @Singleton
    @Provides
    fun provideFireBaseAuthHelper(firebaseRepo: FirebaseRepo, userCachedSource: UserCachedSource): FireBaseAuthHelper {
        return FireBaseAuthHelper(firebaseRepo, userCachedSource)
    }

    @Singleton
    @Provides
    fun provideContext(application: MyApp): Context {
        return application
    }


    @Singleton
    @Provides
    fun provideFireBaseRepo(userCachedSource: UserCachedSource): FirebaseRepo {
        return FirebaseRepo(userCachedSource)
    }


    @Singleton
    @Provides
    fun provideValidationTool(): AwesomeValidation {
        return AwesomeValidation(ValidationStyle.BASIC)
    }


    @Singleton
    @Provides
    fun provideChatRemoteSource():ChatRemoteSource{
        return ChatRemoteSource()
    }

    @Singleton
    @Provides
    fun provideUserRemoteSource():UserRemoteSource{
        return UserRemoteSource()
    }

    @Singleton
    @Provides
    fun provideChatCachedSource(sharedPreferencesManager: SharedPreferencesManager):ChatCachedSource{
        return ChatCachedSource(sharedPreferencesManager)
    }

    @Singleton
    @Provides
    fun provideUserCachedSource(sharedPreferencesManager: SharedPreferencesManager): UserCachedSource {
        return UserCachedSource(sharedPreferencesManager)
    }

    @Singleton
    @Provides
    fun provideUserRepository(userRemoteSource: UserRemoteSource,userCachedSource: UserCachedSource): UserRepository {
        return UserRepository(userCachedSource,userRemoteSource)
    }


    @Singleton
    @Provides
    fun provideDialogsRepository(userCachedSource: UserCachedSource, firebaseRepo: FirebaseRepo): DialogRepository {
        return DialogRepository(userCachedSource, firebaseRepo)
    }


    @Singleton
    @Provides
    fun provideEventsRepository(firebaseRepo: FirebaseRepo): EventsRepository {
        return EventsRepository(firebaseRepo)
    }


    @Singleton
    @Provides
    fun provideChatRepository(chatCachedSource: ChatCachedSource,chatRemoteSource: ChatRemoteSource):ChatRepository{
        return ChatRepository(chatCachedSource,chatRemoteSource)
    }

}