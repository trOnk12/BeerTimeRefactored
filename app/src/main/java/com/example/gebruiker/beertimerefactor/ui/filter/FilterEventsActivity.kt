package com.example.gebruiker.beertimerefactor.ui.filter

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.gebruiker.beertimerefactor.R
import dagger.android.support.DaggerAppCompatActivity
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_filter_event.*

class FilterEventsActivity : DaggerAppCompatActivity(), View.OnClickListener {
    companion object {
        fun createFilterEventActivity(context: Context): Intent {
            return Intent(context, FilterEventsActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_event)

        event_enviroment_options.viewTreeObserver.addOnGlobalLayoutListener { (event_enviroment_options.selectedView as TextView).setTextColor(Color.WHITE) }
        event_type_options.viewTreeObserver.addOnGlobalLayoutListener { (event_type_options.selectedView as TextView).setTextColor(Color.WHITE) }

        //TODO refactor to customview with VieWModel
        tolerant_icon.setOnClickListener(this)
        peacefull_icon.setOnClickListener(this)
        alcohol_free_icon.setOnClickListener(this)
        dog_friendly_icon.setOnClickListener(this)
    }


    //TODO refactor to customview with VieWModel
    override fun onClick(v: View?) {

        when (v!!.id) {
            R.id.tolerant_icon -> switchButton(v)
            R.id.peacefull_icon -> switchButton(v)
            R.id.alcohol_free_icon -> switchButton(v)
            R.id.dog_friendly_icon -> switchButton(v)
        }
    }

    private fun switchButton(view: View?) {
        val button = view as CircleImageView

        when (view.tag) {
            "on" -> button.animate()
                    .alpha(1.0f)
                    .setDuration(200)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            button.tag = "off"
                        }
                    })
            "off" -> button.animate()
                    .alpha(0.3f)
                    .setDuration(200)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            button.tag = "on"
                        }
                    })
        }

    }
}