package com.example.gebruiker.beertimerefactor.ui.custom

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.example.gebruiker.beertimerefactor.R
import com.google.android.gms.maps.model.Circle
import de.hdodenhof.circleimageview.CircleImageView

class CustomRoundButton(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    var view: View = ConstraintLayout.inflate(context, R.layout.custom_round_button, this)
    var roundButton:CircleImageView = findViewById(R.id.round_button)

    init {

        roundButton.setOnClickListener {
            toggleButton(it)
        }

    }

    private fun toggleButton(it: View) {

        when(it.tag){
            false -> it.alpha = 0.2F
            true -> it.alpha = 1.0F
        }
    }

}