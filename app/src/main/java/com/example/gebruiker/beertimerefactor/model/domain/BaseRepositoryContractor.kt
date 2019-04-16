package com.example.gebruiker.beertimerefactor.model.domain

import com.google.firebase.database.DataSnapshot

interface BaseRepositoryContractor<T> {

    fun onDataReceived(data: T)

}
