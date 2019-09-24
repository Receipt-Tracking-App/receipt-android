package com.receipttracker.model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room

class SavedReceiptsDBERepository (val context: Context): ReceiptRepoInterface{

    override fun getAllReceipts(): LiveData<List<SavedReceipt>> {
        return database.savedReceiptsDao().getAllReceipts()
    }

    override fun createReceipt(receipt: SavedReceipt) {
        database.savedReceiptsDao().createReceipt(receipt)
    }

    override fun updateReceipt(savedReceipt: SavedReceipt) {
        database.savedReceiptsDao().updateReceipt(savedReceipt)

    }

    override fun deleteReceipt(savedReceipt: SavedReceipt) {
        database.savedReceiptsDao().deleteReceipt(savedReceipt)
    }
    private val database by lazy {
        Room.databaseBuilder(
            context.applicationContext,
            SavedReceiptDB::class.java, "receipts_database"
        ).fallbackToDestructiveMigration().build()
    }

}