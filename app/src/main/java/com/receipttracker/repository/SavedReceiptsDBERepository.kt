package com.receipttracker.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.receipttracker.local.AppDB
import com.receipttracker.model.SavedReceipt
import com.receipttracker.remote.ReceiptTrackerService

class SavedReceiptsDBERepository (val context: Context) :
    ReceiptRepoInterface {

    private val database = AppDB.getDatabase(context)
    private val apiFactory = apiFactory()





    override fun apiFactory(): ReceiptTrackerService {
        return super.apiFactory()
    }

    override fun create(obj: SavedReceipt) {
        database.savedReceiptsDao().insert(obj)
    }

    override fun update(obj: SavedReceipt) {
        database.savedReceiptsDao().update(obj)
    }

    override fun delete(obj: SavedReceipt) {
        database.savedReceiptsDao().delete(obj)
    }

    override fun getAllReceipts(): LiveData<List<SavedReceipt>> {
        return database.savedReceiptsDao().getAllReceipts()
    }




}