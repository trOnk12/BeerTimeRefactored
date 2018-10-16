package com.example.gebruiker.beertimerefactor.ui.login

import com.example.gebruiker.beertimerefactor.model.repo.FireBaseAuthHelper
import org.junit.Assert
import org.junit.Test

import org.mockito.Mockito.mock

class LoginPresenterTest {

    @Test
    fun login() {
        val firebaseAuthHelper = mock(FireBaseAuthHelper::class.java)

        val loginPresenter = LoginPresenter(firebaseAuthHelper)

        loginPresenter.login("m.pachulski94@gmail.com","Acostam12@")
        Assert.assertEquals(true,loginPresenter.loggedIn())


        loginPresenter.login("m.asdafasdgsagafds@gmail.com","Acostam12@")
        Assert.assertEquals(false,loginPresenter.loggedIn())

    }
}