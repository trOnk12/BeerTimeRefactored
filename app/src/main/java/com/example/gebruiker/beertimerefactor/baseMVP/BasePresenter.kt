package com.example.gebruiker.beertimerefactor.baseMVP

abstract class BasePresenter<T : BaseView>{
    private lateinit var view : T

    fun attachView(view : T){
        this.view = view
    }

    fun getView() = view

}