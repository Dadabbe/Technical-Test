package com.example.tt_invoxia.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Location(
    @SerializedName("timestamp") @Expose var timestamp: Int? = null,
    @SerializedName("lat") @Expose var latitude: Double,
    @SerializedName("lng") @Expose var longitude: Double
)

data class  LocationContainer(
    var locations : List<Location>? =null
)
