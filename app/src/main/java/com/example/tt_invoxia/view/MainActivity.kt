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

        //Locations List Actions

        //println("testmark 1")
        var list = getLocations(this)
        println(list)
        val listSize = list.locations!!.size
        println(list.locations?.get(0)?.latitude)
        println(list.locations?.get(0)?.longitude)
        val complete = getCompleteAddressString(list.locations!!.get(1).latitude,list.locations!!.get(1).longitude,this)

        //RecyclerView Actions

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<LocationViewModel>()
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