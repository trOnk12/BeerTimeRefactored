package com.example.gebruiker.beertimerefactor.ui.custom

import android.content.Context
import android.os.Handler
import android.support.animation.DynamicAnimation
import android.support.animation.SpringAnimation
import android.support.animation.SpringForce
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.gebruiker.beertimerefactor.R

class CustomChatIcon(context : Context, attrs: AttributeSet) : ConstraintLayout(context,attrs) {

    var chatCount : Int = 0
    var isAnimate : Boolean = false
    var view : View = inflate(context, R.layout.chat_icon, this)

    public interface OnChatClickListener {
        fun onChatClick()
    }

    lateinit var listener : OnChatClickListener

    init {

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

            val springUp = SpringAnimation(this, DynamicAnimation.TRANSLATION_Y, -3f)

            val springDown = SpringAnimation(this, DynamicAnimation.TRANSLATION_Y, 3f)

            springUp.spring.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY

            springDown.addEndListener { p0, p1, p2, p3 ->
                Handler().postDelayed({
                    springUp.start()
                }, 100)
            }

            springUp.addEndListener { p0, p1, p2, p3 ->
                Handler().postDelayed({
                    springDown.start()
                }, 100)
            }

            springUp.start()

        }

        view.setOnClickListener {
            listener.onChatClick()
        }

    }

    fun setMessageCount(messageCount : Int){

    }

    fun setOnChatClickListener(listener: OnChatClickListener){
        this.listener = listener
    }

}