package com.example.gebruiker.beertimerefactor

import com.example.gebruiker.beertimerefactor.di.DaggerAppComponent
import com.google.firebase.FirebaseApp
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out MyApp> {
        FirebaseApp.initializeApp(applicationContext)

        return DaggerAppComponent.builder().create(this)

    }

}