package com.example.gebruiker.beertimerefactor.ui.main.fragments.di

import com.example.gebruiker.beertimerefactor.ui.main.fragments.EventsMainFragment
import com.example.gebruiker.beertimerefactor.ui.main.fragments.FeedMainFragment
import com.example.gebruiker.beertimerefactor.ui.main.fragments.PeopleMainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmenstProvider {

    @ContributesAndroidInjector(modules = arrayOf(EventsMainFragmentModule::class))
    internal abstract fun provideDetailFragmentFactory(): EventsMainFragment

    @ContributesAndroidInjector
    internal abstract fun providePeopleFragmentFactory(): PeopleMainFragment

    @ContributesAndroidInjector
    internal abstract fun provideFeedFragmentFactory(): FeedMainFragment

}