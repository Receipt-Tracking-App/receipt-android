package com.receipttracker.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Factory {

    companion object {

        fun create(): ReceiptTrackerService {

            val logger = HttpLoggingInterceptor()

            logger.level = HttpLoggingInterceptor.Level.BASIC

            logger.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()

                .addInterceptor(logger)

                .retryOnConnectionFailure(false)

                .readTimeout(10, TimeUnit.SECONDS)

                .connectTimeout(15, TimeUnit.SECONDS)

                .build()

            val retrofit = Retrofit.Builder()

                .client(okHttpClient)

                .baseUrl(ReceiptTrackerService.BASE_URL)

                .addConverterFactory(GsonConverterFactory.create())

                .build()


            return retrofit.create(ReceiptTrackerService::class.java)

        }
    }

}