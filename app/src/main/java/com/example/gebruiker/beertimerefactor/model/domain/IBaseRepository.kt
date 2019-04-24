package com.example.gebruiker.beertimerefactor.model.domain

import com.google.firebase.database.DataSnapshot

interface IBaseRepository<T> {

    fun onDataReceived(data: T)

}
