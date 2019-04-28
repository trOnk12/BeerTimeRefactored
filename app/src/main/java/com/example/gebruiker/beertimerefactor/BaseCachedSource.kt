package com.example.gebruiker.beertimerefactor

abstract class BaseCachedSource<T> {

    abstract fun putData(data:T)
    abstract fun getData():T?
    abstract fun empty(): Boolean

}