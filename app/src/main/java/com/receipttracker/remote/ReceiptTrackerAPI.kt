package com.receipttracker.remote

import com.receipttracker.model.ReceiptOverview
import com.receipttracker.model.User
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ReceiptTrackerService {

    @GET("/receipts/users/{id}")
    fun getUserReceiptsByID(@Path ("id") receiptId: Int) : List<ReceiptOverview>


    @POST("/auth/register")
    fun createUser(@Body request: RequestBody): Call<User>

    @POST("/auth/login")
    fun userLoginPost(@Body request: RequestBody): Call<User>

    companion object {

        const val BASE_URL = "https://lambda-receipt-tracker.herokuapp.com/api"

        private val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .baseUrl(BASE_URL)
            .build()
    }
}