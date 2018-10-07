package com.example.gebruiker.beertimerefactor

import com.example.gebruiker.beertimerefactor.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out MyApp> {
        return DaggerAppComponent.builder().create(this)
    }

}