package com.example.tt_invoxia.viewmodel

import android.content.Context
import android.icu.text.SimpleDateFormat
import android.location.Address
import com.example.tt_invoxia.model.LocationContainer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import android.location.Geocoder
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.lang.Exception
import java.lang.StringBuilder
import java.util.*


class LocationViewModel(val date: String?, val address: String){

}

fun getLocations(context: Context) : LocationContainer{
    lateinit var jsonString : String
    try {
        jsonString = context.assets.open("data.json")
            .bufferedReader()
            .use{it.readText()}
    }catch (ioException : IOException){
        throw ioException
    }

    val listLocationType = object : TypeToken<LocationContainer>(){}.type
    return Gson().fromJson(jsonString,listLocationType)
}

fun getCompleteAddressString(LATITUDE: Double, LONGITUDE: Double, context: Context): String? {
    var strAdd = ""
    val geocoder = Geocoder(context, Locale.getDefault())
    try {
        val addresses: List<Address>? = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1)
        if (addresses != null) {
            val returnedAddress: Address = addresses[0]
            val strReturnedAddress = StringBuilder("")
            for (i in 0..returnedAddress.getMaxAddressLineIndex()) {
                strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n")
            }
            strAdd = strReturnedAddress.toString()
            Log.w("My Current loction add", strReturnedAddress.toString())
        } else {
            Log.w("Location Error", "No Address returned!")
        }
    } catch (e: Exception) {
        e.printStackTrace()
        Log.w("Location Error", "Cannot get Address!")
    }
    return strAdd
}

@RequiresApi(Build.VERSION_CODES.N)
fun getDateTime(s: String): String?{
    try {
        val sdf = SimpleDateFormat("MM/dd/yyyy 'at' HH:mm:ss")
        val netDate = Date(s.toLong() * 1000)
        return sdf.format(netDate)
    } catch (e: Exception) {
        return e.toString()
    }
}