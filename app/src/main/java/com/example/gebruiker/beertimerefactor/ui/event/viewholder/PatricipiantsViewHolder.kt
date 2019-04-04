package com.example.gebruiker.beertimerefactor.ui.event.viewholder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.ui.main.fragments.viewholder.HorizontalRecyclerAdapter
import kotlinx.android.synthetic.main.custom_toolbar_.view.*
import kotlinx.android.synthetic.main.fragment_event_description.view.*
import kotlinx.android.synthetic.main.patricipaints_item_view.view.*

class PatricipiantsViewHolder : RecyclerView.Adapter<PatricipiantsViewHolder.ViewHolder>() {

    lateinit var patricipiantsList : ArrayList<User>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.patricipaints_item_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return patricipiantsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(patricipiantsList[position])
    }

    fun setItems(patricipiantsList:ArrayList<User>){
        this.patricipiantsList = patricipiantsList
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bind(user:User){
            itemView.profile_name_patricitpiants.text = user.name
        }

    }
}