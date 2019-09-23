package com.receipttracker.model

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [SavedReceipt::class], version = 2, exportSchema = false)
abstract class SavedReceiptDB : RoomDatabase(){
    abstract fun savedReceiptsDao() : SavedReceiptDao
}