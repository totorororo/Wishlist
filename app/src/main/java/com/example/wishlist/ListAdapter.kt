package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val mItems: List<ListItem>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // as you render a row.
        val itemText: TextView
        val priceText: TextView
        val urlText: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {

            // the public final member variables created above
            itemText = itemView.findViewById(R.id.ItemName)
            priceText = itemView.findViewById(R.id.ItemPrice)
            urlText = itemView.findViewById(R.id.ItemLink)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item_layout, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return mItems.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item: ListItem = mItems.get(position)

        holder.itemText.setText(item.name)
        holder.priceText.setText(item.price.toString())
        holder.urlText.setText(item.url)

    }
}
