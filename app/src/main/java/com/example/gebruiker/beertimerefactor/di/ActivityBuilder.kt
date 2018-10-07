package com.example.gebruiker.beertimerefactor.di

import com.example.gebruiker.beertimerefactor.ui.login.LoginActivity
import com.example.gebruiker.beertimerefactor.ui.login.di.LoginActivityModule
import com.example.gebruiker.beertimerefactor.ui.register.RegisterActivity
import com.example.gebruiker.beertimerefactor.ui.register.di.RegisterModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

    @Module
    abstract class ActivityBuilder {

        @ContributesAndroidInjector(modules = [LoginActivityModule::class])
        abstract fun bindLoginActivity(): LoginActivity


        @ContributesAndroidInjector(modules = [RegisterModule::class])
        abstract fun bindRegisterActivity(): RegisterActivity

    }

