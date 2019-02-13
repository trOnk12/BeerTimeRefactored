package com.example.gebruiker.beertimerefactor.di

import com.example.gebruiker.beertimerefactor.ui.SplashActivity
import com.example.gebruiker.beertimerefactor.ui.chat.ChatActivity
import com.example.gebruiker.beertimerefactor.ui.chat.di.ChatActivityModule
import com.example.gebruiker.beertimerefactor.ui.login.LoginActivity
import com.example.gebruiker.beertimerefactor.ui.login.di.LoginActivityModule
import com.example.gebruiker.beertimerefactor.ui.main.MainActivity
import com.example.gebruiker.beertimerefactor.ui.main.di.MainActivityModule
import com.example.gebruiker.beertimerefactor.ui.dialogs.DialogsActivity
import com.example.gebruiker.beertimerefactor.ui.dialogs.di.DialogsActivityModule
import com.example.gebruiker.beertimerefactor.ui.register.RegisterActivity
import com.example.gebruiker.beertimerefactor.ui.register.di.RegisterModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [RegisterModule::class])
    abstract fun bindRegisterActivity(): RegisterActivity

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [DialogsActivityModule::class])
    abstract fun bindMessageActivity(): DialogsActivity

    @ContributesAndroidInjector(modules = [ChatActivityModule::class])
    abstract fun bindChatActivity(): ChatActivity

}

