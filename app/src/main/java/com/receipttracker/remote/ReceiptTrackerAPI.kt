package com.receipttracker.remote

import com.receipttracker.model.ReceiptOverview
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ReceiptTrackerAPI {

    @GET("/receipts/users/{id}")
    fun getUserReceiptsByID(@Path ("id") receiptId: Int) : List<ReceiptOverview>


    @POST("/auth/register") // Todo: Add user Model
    fun userRegistrationPost(@Body request: RequestBody): Call<//>

    @POST("/auth/login") // Todo: Add user Model
    fun userLoginPost(@Body request: RequestBody): Call<//>



}