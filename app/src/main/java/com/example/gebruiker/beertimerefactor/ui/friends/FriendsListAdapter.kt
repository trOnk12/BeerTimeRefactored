package com.example.gebruiker.beertimerefactor.ui.friends

import android.support.v7.view.menu.MenuView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.example.gebruiker.beertimerefactor.R
import com.example.gebruiker.beertimerefactor.model.User
import com.example.gebruiker.beertimerefactor.ui.event.viewholder.ParticipantsAdapter
import kotlinx.android.synthetic.main.friends_list_item.view.*

class FriendsListAdapter(private var listener:onItemClickListener) : RecyclerView.Adapter<FriendsListAdapter.ViewHolder>() {

    var friendsList = ArrayList<User>()

    interface onItemClickListener{
        fun onItemClick(user:User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.friends_list_item,parent,false)
        return FriendsListAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
      return  friendsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener { listener.onItemClick(friendsList[position])}
        holder.bind(friendsList[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(user: User) {
            itemView.friend_name.text="Name: "+user.name
            itemView.friend_country.text="Country: "
            itemView.friend_city.text="City: "
            itemView.friend_since.text="Since: "
        }

    }
}