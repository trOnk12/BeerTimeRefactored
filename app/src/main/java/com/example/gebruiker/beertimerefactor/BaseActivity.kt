package com.example.gebruiker.beertimerefactor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gebruiker.beertimerefactor.baseMVP.BasePresenter
import com.example.gebruiker.beertimerefactor.baseMVP.BaseView
import dagger.android.support.DaggerAppCompatActivity
import kotlin.coroutines.experimental.coroutineContext
import kotlin.reflect.KProperty

abstract class BaseActivity : DaggerAppCompatActivity(),BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        attachPresenter()
    }

    fun showToast(mMessage: String) {
        Toast.makeText(this, mMessage, Toast.LENGTH_SHORT).show()
    }

    fun launchActivityWithFinish(intent: Intent){
        startActivity(intent)
        finish()

    }

    class MyAnimatingView : View(coroutineContext) {
        // delegated property.
        // Uses the getter and setter defined in InvalidateDelegate
        var foregroundX by InvalidateDelegate("dupa")

    }
    // A View Delegate which invalidates
// View.postInvalidateOnAnimation when set.
    class InvalidateDelegate<T : Any>(var value: T) {
        operator fun getValue(thisRef: View,
                              property: KProperty<*>) = value
        operator fun setValue(thisRef: View,
                              property: KProperty<*>, value: T) {
            this.value = value
            thisRef.postInvalidateOnAnimation()
        }
    }

    abstract fun attachPresenter()

}