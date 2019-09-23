package com.receipttracker.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONException
import org.json.JSONObject

/*    val price: String,
    val receiptId: Int = 0,
    val date: String,
    val location: String,
    val service: String*/
@Entity
class SavedReceipt{
    companion object{
        const val INVALID_ID = 0
    }
    var price: String = ""
    var date: String = ""
    var location: String = ""
    var service: String = ""
    @PrimaryKey(autoGenerate = true) @NonNull
    var receiptId: Int = 0


    constructor(price: String, date: String, location: String, service: String, receiptId: Int){
        this.price = price
        this.date = date
        this.location = location
        this.service = service
        this.receiptId = receiptId
    }
    constructor(jsonObject: JSONObject){
        try {
            this.service = jsonObject.getString("service")
        }catch (e: JSONException){
            this.service = ""
        }
        try{
            this.location = jsonObject.getString("location")
        }catch (e: JSONException){
            this.location = ""
        }
        try {
            this.date = jsonObject.getString("date")
        }catch (e: JSONException){
            this.date = ""
        }
        try {
            this.price = jsonObject.getString("price")
        }catch (e: JSONException){
            this.price = ""
        }
        try {
            this.receiptId = jsonObject.getInt("1")
        }catch (e: JSONException){
            this.receiptId = 1
        }


    }


}