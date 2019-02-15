package com.example.gebruiker.beertimerefactor.ui.custom

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.design.widget.TextInputLayout
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import com.example.gebruiker.beertimerefactor.R
import android.animation.ValueAnimator



class CustomSearchBar(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    var view: View = inflate(context, R.layout.custom_search_toolbar, this)

    val searchIcon: ImageView = findViewById(R.id.search_icon)
    val searchInput : TextInputLayout = findViewById(R.id.text_input)

    init {
        searchIcon.setOnClickListener {
            showSearchInput()
        }
    }

    private fun showSearchInput() {

        val widthAnimator = ValueAnimator.ofInt(1, 300)
        widthAnimator.addUpdateListener { animation ->
            val animatedValue = animation.animatedValue as Int
            searchInput.layoutParams.width = animatedValue
            searchInput.requestLayout()
        }

        widthAnimator.duration = 1000


        searchIcon.animate()
                .alpha(0f)
                .setDuration(750)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        searchIcon.visibility = View.GONE
                    }
                })

        searchInput.animate()
                .alpha(1f)
                .setDuration(200)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        searchInput.visibility = View.VISIBLE
                        widthAnimator.start()
                    }
                })




    }

    fun closeSearchInput() {

    }
}
