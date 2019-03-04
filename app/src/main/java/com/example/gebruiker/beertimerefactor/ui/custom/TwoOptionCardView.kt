package com.example.gebruiker.beertimerefactor.ui.custom

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.example.gebruiker.beertimerefactor.R
import kotlinx.android.synthetic.main.custom_two_option_cards.view.*

class TwoOptionCardView(context: Context,attributeSet: AttributeSet) : LinearLayout(context,attributeSet) {

    var view : View = LinearLayout.inflate(context, R.layout.custom_two_option_cards, this)

    var option1Container: LinearLayout = findViewById(R.id.option_1)
    var option2Container: LinearLayout = findViewById(R.id.option_2)

    fun setOption1Listener(onClickListener: OnClickListener){
        option1Container.setOnClickListener(onClickListener)
    }

    fun setOption2Listener(onClickListener: OnClickListener){
        option2Container.setOnClickListener(onClickListener)
    }

    fun setOption1Title(title : String){
            option1_title.text=title
    }

    fun setOption2Title(title : String){
        option2_title.text=title
    }

    fun setOption1Body(body :String){
        option1_body.text=body
    }

    fun setOption2Body(body :String){
        option2_body.text=body
    }

}