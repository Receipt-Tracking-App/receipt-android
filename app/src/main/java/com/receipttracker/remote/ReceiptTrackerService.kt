package com.receipttracker.remote

import com.google.gson.annotations.SerializedName
import com.receipttracker.model.ReceiptOverview
import com.receipttracker.model.SavedReceipt
import com.receipttracker.model.User
import com.receipttracker.model.UserLogin
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.*

interface ReceiptTrackerService {

    @GET("receipts/users/{id}")
    fun getUserReceiptsByID(@Path ("id") receiptId: Int) : List<SavedReceipt>

    @POST("receipts")
    fun createNewReceipt(@Body request: RequestBody): Call<SavedReceipt>

    @PUT("receipts/{id}")
    fun updateReceipt(@Body request: RequestBody): Call<SavedReceipt>

    //@POST("/receipts/{id}/upload")


    @POST("auth/register")
    fun createUser(@Body request: RequestBody): Call<User>

    @POST("auth/login")
    fun userLoginPost(@Body userLogin: UserLogin) : Call<User>

    companion object {

        const val BASE_URL = "https://lambda-receipt-tracker.herokuapp.com/api/"

        private val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .baseUrl(BASE_URL)
            .build()
    }
}