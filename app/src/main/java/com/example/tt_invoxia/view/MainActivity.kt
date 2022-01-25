package com.example.tt_invoxia.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tt_invoxia.R
import com.example.tt_invoxia.viewmodel.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //LocationsList Actions

        val list = getLocations(this)
        val listSize = list.locations!!.size

        //RecyclerView Actions

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val data = mutableListOf<LocationViewModel>()
        for(i in 0 until listSize){
            data.add(
                LocationViewModel(
                    getDateTime(list.locations!![i].timestamp.toString()),
                getCompleteAddressString(list.locations!!.get(i).latitude,list.locations!!.get(i).longitude,this)!!
            ))
        }
        val adapter = LocationAdapter(data)
        recyclerView.adapter = adapter


    }
}