package com.receipttracker.model

import android.app.Application
import com.receipttracker.repository.ReceiptRepoInterface
import com.receipttracker.repository.SavedReceiptsDBERepository
import com.receipttracker.repository.UserDBRepository
import com.receipttracker.repository.UserRepoInterface

val receiptRepo: ReceiptRepoInterface by lazy{
    App.receiptRepo!!
}

val userRepo: UserRepoInterface by lazy {
    App.userRepo!!
}

class App : Application(){
    companion object{
        var receiptRepo: ReceiptRepoInterface? = null
        var userRepo: UserRepoInterface? = null

    }

    override fun onCreate() {
        super.onCreate()
        receiptRepo = SavedReceiptsDBERepository(applicationContext)
        userRepo = UserDBRepository(applicationContext)
    }
}