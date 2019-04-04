package com.example.gebruiker.beertimerefactor.ui.main.fragments.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.gebruiker.beertimerefactor.model.Event
import android.view.LayoutInflater
import android.widget.AdapterView
import com.example.gebruiker.beertimerefactor.R
import kotlinx.android.synthetic.main.horizontal_recycler_view_item.view.*

class HorizontalRecyclerAdapter : RecyclerView.Adapter<HorizontalRecyclerAdapter.ViewHolder>() {

    private lateinit var items: ArrayList<Event>

     lateinit var onItemOnClickListener: ItemOnClickListener

    interface ItemOnClickListener{
        fun onItemClick(event : Event)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HorizontalRecyclerAdapter.ViewHolder, position: Int) {

        val event: Event = items[position]
        holder.bind(event)
        holder.itemView.setOnClickListener{onItemOnClickListener.onItemClick(items[position])}

    }

    fun setData(items: ArrayList<Event>) {
        this.items = items
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bind(event: Event) {
            itemView.item_title_tv.text = event.name
        }

    }

}