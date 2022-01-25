package com.example.tt_invoxia.viewmodel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tt_invoxia.R


class LocationAdapter(private val locationList: List<LocationViewModel>) : RecyclerView.Adapter<LocationAdapter.ViewHolder>() {

        // create new views
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            // inflates the card_view_design view
            // that is used to hold list item
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_view_location, parent, false)

            return ViewHolder(view)
        }

        // binds the list items to a view
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val ItemsViewModel = locationList[position]

            // sets the text to the textview from our itemHolder class
            holder.textViewAddress.text = ItemsViewModel.address
            holder.textViewDate.text = ItemsViewModel.date.toString()

        }

        // return the number of the items in the list
        override fun getItemCount(): Int {
            return locationList.size
        }

        // Holds the views for adding it to image and text
        class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
            val imageView: ImageView = itemView.findViewById(R.id.imageview)
            val textViewAddress: TextView = itemView.findViewById(R.id.textViewAddress)
            val textViewDate : TextView = itemView.findViewById(R.id.textViewDate)
        }
    }
