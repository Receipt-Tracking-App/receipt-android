package com.receipttracker.model

import androidx.room.Database
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Room

@Database(entities = [SavedReceipt::class], version = 2, exportSchema = false)
abstract class SavedReceiptDB : RoomDatabase(){
    abstract fun savedReceiptsDao() : SavedReceiptDao

    companion object {
        // Singleton prevents multiple instances of database from opening at the same time
        @Volatile
        private var INSTANCE: SavedReceiptDB? = null

        fun getDatabase(context: Context) : SavedReceiptDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SavedReceiptDB::class.java,
                    "saved_receipt_database"
                ).build()
                INSTANCE = instance
                return getDatabase(context)
            }
        }
    }
}