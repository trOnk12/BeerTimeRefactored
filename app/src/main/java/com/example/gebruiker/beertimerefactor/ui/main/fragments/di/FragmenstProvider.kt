package com.example.gebruiker.beertimerefactor.ui.main.fragments.di

import com.example.gebruiker.beertimerefactor.ui.main.fragments.EventsMainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmenstProvider {

    @ContributesAndroidInjector(modules = arrayOf(EventsMainFragmentModule::class))
    internal abstract fun provideDetailFragmentFactory(): EventsMainFragment

}