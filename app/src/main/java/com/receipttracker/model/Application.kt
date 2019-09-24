package com.receipttracker.model

import android.app.Application
import com.receipttracker.repository.ReceiptRepoInterface
import com.receipttracker.repository.SavedReceiptsDBERepository

val repo: ReceiptRepoInterface by lazy{
    App.repo!!
}

class App : Application(){
    companion object{
        var repo: ReceiptRepoInterface? = null

    }

    override fun onCreate() {
        super.onCreate()
        repo = SavedReceiptsDBERepository(applicationContext)
    }
}