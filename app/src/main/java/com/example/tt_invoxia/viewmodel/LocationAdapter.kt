package com.example.tt_invoxia.viewmodel
import android.annotation.SuppressLint
//import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
//import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

import com.example.tt_invoxia.R


class LocationAdapter(private var locationList: MutableList<LocationViewModel>) : RecyclerView.Adapter<LocationAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_view_location, parent, false)
            return ViewHolder(view)
        }

        @SuppressLint("NotifyDataSetChanged")
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            //Absence de contexte pour les toasts
            //val toast = Toast.makeText(,"Location supprimée !", Toast.LENGTH_SHORT)
            val ItemsViewModel = locationList[position]
            holder.textViewAddress.text = ItemsViewModel.address
            holder.textViewDate.text = ItemsViewModel.date.toString()
            holder.deleteButton.setOnClickListener{
                    locationList.removeAt(position)
                    notifyDataSetChanged()
                    //toast.show()

            }

        }
        override fun getItemCount(): Int {
            return locationList.size
        }

        class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
            val textViewAddress: TextView = itemView.findViewById(R.id.textViewAddress)
            val textViewDate : TextView = itemView.findViewById(R.id.textViewDate)
            val deleteButton : ImageButton = itemView.findViewById(R.id.deleteButton)
        }


}
