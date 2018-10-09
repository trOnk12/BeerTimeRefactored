package com.example.gebruiker.beertimerefactor.ui

import android.content.Context
import android.support.animation.DynamicAnimation
import android.support.animation.SpringAnimation
import android.support.animation.SpringForce
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.VelocityTracker
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.gebruiker.beertimerefactor.R

class CustomChatIcon(context : Context, attrs: AttributeSet) : ConstraintLayout(context,attrs) {

    var chatCount : Int = 0
    var isAnimate : Boolean = false
    var mVelocityTracker : VelocityTracker = VelocityTracker.obtain()

    init {

        inflate(context, R.layout.chat_icon, this)

        val chatIcon: ImageView = findViewById(R.id.chat_icon)
        val messageCount: TextView = findViewById(R.id.message_count)

        context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.CustomChatIcon,
                0, 0).apply {

            try {
                chatCount = getInteger(R.styleable.CustomChatIcon_messageCount, 0)
                isAnimate = getBoolean(R.styleable.CustomChatIcon_animateJump, false)
            } finally {
                recycle()
            }
        }

        if(isAnimate){

            val springAnim = SpringAnimation(this, DynamicAnimation.TRANSLATION_Y, -20f)

            springAnim.spring.dampingRatio = SpringForce.DAMPING_RATIO_LOW_BOUNCY

            springAnim.start()

        }

    }

}